package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Popout_ReviewInformation extends AppCompatActivity {

    Button btnSignUp;
    TextView name, username, code, relation, setRelationText;
    DBHelper DB;
    EditText retypeCode;
    Boolean insertData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_reviewinformation);

        //Text View
        name = findViewById(R.id.setName); //initialize name
        username = findViewById(R.id.setUName); //initialize phone number
        code = findViewById(R.id.setCode2);
        relation = findViewById(R.id.setRelation); //initialize relation
        setRelationText = findViewById(R.id.setRelationText); //initialize label

        //Button
        btnSignUp = findViewById(R.id.signup); //initialize sign up

        //Database
        DB = new DBHelper(this);

        //Get text from Intent
        Intent intent = getIntent();
        String getName = intent.getStringExtra("name");
        String getUsername = intent.getStringExtra("username");
        String getCode = intent.getStringExtra("code");
        String getRelation = intent.getStringExtra("relation");

        //Set Text
        name.setText(getName);
        username.setText(getUsername);
        code.setText(getCode);
        relation.setText(getRelation);

        btnSignUp.setOnClickListener(view -> openWelcome());
    }

    public void openWelcome(){
        Intent i = new Intent(Popout_ReviewInformation.this, Popout_WelcomeToHearduino.class);
        startActivity(i);
    }
}
