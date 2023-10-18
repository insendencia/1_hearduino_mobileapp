package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
    TextView name, email, num, code, relation, setRelationText;
    DBHelper DB;
    Boolean checkNameEmail, insertData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_reviewinformation);

        //Text View
        name = findViewById(R.id.setName); //initialize name
        email = findViewById(R.id.setEmail); //initialize email
        num = findViewById(R.id.setNum); //initialize phone number
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
        String getNumber = intent.getStringExtra("number");
        String getEmail = intent.getStringExtra("email");
        String getCode = intent.getStringExtra("code");
        String getRelation = intent.getStringExtra("relation");

        //Set Text
        name.setText(getName);
        num.setText(getNumber);
        email.setText(getEmail);
        code.setText(getCode);
        relation.setText(getRelation);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            String setName = name.getText().toString();
            String setEmail = email.getText().toString();
            String setNumber = num.getText().toString();
            String setCode = code.getText().toString();
            String setRelation = relation.getText().toString();
            @Override
            public void onClick(View view) {
                if(checkNameEmail == false){
                    insertData = DB.insertData(setName, setEmail, setNumber, setCode, setRelation);

                    if(insertData == true){
                        Intent i = new Intent(getApplicationContext(), Popout_WelcomeToHearduino.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Popout_ReviewInformation.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Popout_ReviewInformation.this, "Account already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
