package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Popout_ReviewInformation extends AppCompatActivity {

    Button btnSignUp;
    TextView name, email, num, relation, setRelationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_reviewinformation);

        //Text View
        name = findViewById(R.id.setName); //initialize name
        email = findViewById(R.id.setEmail); //initialize email
        num = findViewById(R.id.setNum); //initialize phone number
        relation = findViewById(R.id.setRelation); //initialize relation
        setRelationText = findViewById(R.id.setRelationText); //initialize label

        //Button
        btnSignUp = findViewById(R.id.signup); //initialize sign up

        //Get text from Intent
        Intent intent = getIntent();
        String getName = intent.getStringExtra("name");
        String getNumber = intent.getStringExtra("number");
        String getEmail = intent.getStringExtra("email");
        String getRelation = intent.getStringExtra("relation");

        //Set Text
        name.setText(getName);
        num.setText(getNumber);
        email.setText(getEmail);
        relation.setText(getRelation);


        //btnSignUp.setOnClickListener(view -> openWelcomeToHearduino());
    }

}
