package com.example.hearduino_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_WelcomePage extends AppCompatActivity {

    Button btnLogin; //login and sign up button
    //Dialog mDialog;
    EditText username, code;
    TextView btnSignUp;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        //initialize button
        btnLogin = findViewById(R.id.loginbtn);
        btnSignUp = findViewById(R.id.btntext);

        //initialize edit text
        username = findViewById(R.id.typeUsername);
        code = findViewById(R.id.typePasscode);
        //mDialog = new Dialog(this);

        DB = new DBHelper(this);

        //set condition for login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString();
                String Code = code.getText().toString();

                if(Username.equals("")|| Code.equals("")){
                    Toast.makeText(Activity_WelcomePage.this,"Please fill in all credentials", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUNameCode = DB.checkUNameCode(Username, Code);

                    if(checkUNameCode == true){
                        Toast.makeText(Activity_WelcomePage.this, "Welcome!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Activity_UserHome.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Activity_WelcomePage.this,"Invalid email/passcode", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignUp.setOnClickListener(view -> openSignUp());
    }

    public void openSignUp(){
        Intent i = new Intent(Activity_WelcomePage.this, Activity_SignUp.class);
        startActivity(i);
    }
}