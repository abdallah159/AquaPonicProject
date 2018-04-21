package com.example.mohammed.graduationproject.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohammed.graduationproject.R;
import com.example.mohammed.graduationproject.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    ProgressDialog progressDialog;

    ArrayList<User> users;

    EditText userEmail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = findViewById(R.id.userMail);
        userPassword = findViewById(R.id.userPassword);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");
        users = new ArrayList<>();


    }


    public void onClickLogin(View view) {

        if (!isEmailValid(userEmail.getText().toString()))
            userEmail.setError("Please Enter Valid email Adress");

        else if (userPassword.getText().toString().length() < 8)
            userPassword.setError("Please Enter Correct password");

        else {
            progressDialog.show();
            getUsers();
        }

        /*Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(loginIntent);
        LoginActivity.this.finish();*/


    }

    public void onClickRegister(View view) {
        Intent loginIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        LoginActivity.this.startActivity(loginIntent);
        LoginActivity.this.finish();
    }


    public void getUsers() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> item = dataSnapshot.getChildren().iterator();
                while (item.hasNext()) {
                    DataSnapshot it = item.next();
                    User user = it.getValue(User.class);
                    users.add(user);
                }
                checkLogin();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(LoginActivity.this, "" + databaseError.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void checkLogin() {
        for (User user : users) {
            if (userEmail.getText().toString().equals(user.getEmail().toString()) && userPassword.getText().toString().equals(user.getPassword().toString())) {
                if (user.isAdmin().equals("true")) {
                    //Go To Admin Home
                    Toast.makeText(this, "Login as Admin", Toast.LENGTH_SHORT).show();
                    break;
                } else if (user.isAdmin().equals("false")) {
                    //Go to Normal user home

                    Toast.makeText(this, "Login as Normal User", Toast.LENGTH_SHORT).show();
                    break;
                }
            }

        }
        progressDialog.dismiss();
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }

}

