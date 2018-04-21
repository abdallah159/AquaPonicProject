package com.example.mohammed.graduationproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText useNameET, userAdressET, userEmailET, userPhoneET, userJopET, userPasswordET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        useNameET = findViewById(R.id.userName);
        userAdressET = findViewById(R.id.userAdress);
        userEmailET = findViewById(R.id.userMail);
        userPhoneET = findViewById(R.id.userMobile);
        userJopET = findViewById(R.id.userJop);
        userPasswordET = findViewById(R.id.userPassword);


    }

    public void onClickRegister(View view) {
        dataValidation();
       /* Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        RegisterActivity.this.startActivity(loginIntent);
        RegisterActivity.this.finish();*/
    }

    public void onClickLogin(View view) {
      /*  Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        RegisterActivity.this.startActivity(loginIntent);
        RegisterActivity.this.finish();*/


    }


    public void dataValidation() {

        //Validation of Data to register
        if (useNameET.getText().toString().length() == 0)
            useNameET.setError("Field cannot be left empty!");

        else if (userPasswordET.getText().toString().length() == 0)
            userPasswordET.setError("Field cannot be left empty!");

        else if (userJopET.getText().toString().length() == 0)
            userJopET.setError("Field cannot be left empty!");

        else if (userPhoneET.getText().toString().length() == 0)
            userPhoneET.setError("Field cannot be left empty!");

        else if (userEmailET.getText().toString().length() == 0)
            userEmailET.setError("Field cannot be left empty!");

        else if (userAdressET.getText().toString().length() == 0)
            userAdressET.setError("Field cannot be left empty!");

        else if (!isEmailValid(userEmailET.getText().toString()))
            userEmailET.setError("Please enter valid email adress");

        else if (!isValidMobile(userPhoneET.getText().toString()))
            userPhoneET.setError("Please enter valid mobile number");

        else if (userPasswordET.getText().toString().length() < 8)
            userPasswordET.setError("Password must be minimum 8 symbols");

        else if(!isValidString(userAdressET.getText().toString()))
            userAdressET.setError("Please enter valid adress");

        else if(!isValidString(userJopET.getText().toString()))
            userJopET.setError("Please enter valid jop");

        else if(!isValidString(useNameET.getText().toString()))
            useNameET.setError("Please enter valid name");

        else{
            //handle Register here
            registerUser();
        }



    }

    private boolean registerUser() {

        return true ;

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

    private boolean isValidMobile(String phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            if (phone.length() < 6 || phone.length() > 13) {
                // if(phone.length() != 10) {
                check = false;
            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }


    public static boolean isValidString(String input)
    {
        try {
            int i = Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return true;
        }
    }

}
