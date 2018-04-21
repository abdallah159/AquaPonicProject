package com.example.mohammed.graduationproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void onClickLogin(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        /*Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(loginIntent);
        LoginActivity.this.finish();*/


    }

    public void onClickRegister(View view) {
        Intent loginIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        LoginActivity.this.startActivity(loginIntent);
        LoginActivity.this.finish();
    }
}
