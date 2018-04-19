package com.example.mohammed.graduationproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLogin(View view) {

        Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(loginIntent);
        LoginActivity.this.finish();


    }

    public void onClickRegister(View view) {
        Intent loginIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        LoginActivity.this.startActivity(loginIntent);
        LoginActivity.this.finish();
    }
}
