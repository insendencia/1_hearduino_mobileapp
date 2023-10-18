package com.example.hearduino_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_WelcomePage extends AppCompatActivity {

    Button btnLogin, btnSignUp; //login and sign up button
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        btnLogin = findViewById(R.id.loginbtn);
        btnSignUp = findViewById(R.id.signupbtn);
        mDialog = new Dialog(this);

        btnLogin.setOnClickListener(view -> openPopOut());
        btnSignUp.setOnClickListener(view -> openSignUp());
    }

    public void openPopOut(){
        mDialog.setContentView(R.layout.popout_login);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

    public void openSignUp(){
        Intent i = new Intent(Activity_WelcomePage.this, Popout_SignUpWGoogle.class);
        startActivity(i);
    }
}