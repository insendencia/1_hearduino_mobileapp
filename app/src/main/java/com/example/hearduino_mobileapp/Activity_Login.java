package com.example.hearduino_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

public class Activity_Login extends AppCompatActivity {

    Button btn; //login button
    Button btn2; //sign up button
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = (Button) findViewById(R.id.loginbtn);
        btn2 = (Button) findViewById(R.id.signupbtn);
        mDialog = new Dialog(this);

        btn.setOnClickListener(view -> openPopOut());
        btn2.setOnClickListener(view -> openSignUp());
    }

    public void openPopOut(){
        Intent i = new Intent(this, Popout_LoginWGoogle.class);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        startActivity(i);
    }

    public void openSignUp(){
        Intent j = new Intent(this, Popout_SignUpWGoogle.class);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        startActivity(j);
    }
}