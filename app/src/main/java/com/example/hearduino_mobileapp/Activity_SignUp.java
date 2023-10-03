package com.example.hearduino_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Activity_SignUp extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name, email;
    Button yBtn, nBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        yBtn = findViewById(R.id.bYes); //initialize yes button
        nBtn = findViewById(R.id.bNo); //initialize no button
        name = findViewById(R.id.username); //get name
        email = findViewById(R.id.useremail); //get email

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        yBtn.setOnClickListener(view -> openSU2()); //opens next sign up
        nBtn.setOnClickListener(view -> openDYK()); //opens dyk page

        //get data from the account which is signed in
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            //insert to text view
            name.setText(personName);
            email.setText(personEmail);
        }
    }

    public void openSU2(){
        Intent i = new Intent(this, Activity_SignUp2.class);
        startActivity(i);
    }

    public void openDYK(){
        Intent j = new Intent(this, Popout_Dyk.class);
        startActivity(j);
    }

}
