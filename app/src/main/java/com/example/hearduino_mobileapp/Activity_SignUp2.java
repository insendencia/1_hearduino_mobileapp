package com.example.hearduino_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_SignUp2 extends AppCompatActivity {

    TextView name, username, code, cText, rText;
    Button cBtn, signupBtn, nBtn, checkBtn, saveBtn;
    EditText insertCode;

    //spinner for relation
    String[] relation = {"N/A", "Parent", "Child", "Sibling", "Friend", "Spouse", "Other"};
    Spinner spinner1;

    //spinner for yes or no
    String[] choice = {" ", "Yes", "No"};
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        //TextView
        name = findViewById(R.id.setName); //initialize set name
        username = findViewById(R.id.setUsername); //initialize set username
        code = findViewById(R.id.setCode); //initialize set code
        cText = findViewById(R.id.connectAccountText); //initialize text
        rText = findViewById(R.id.relationTextView); //initialize text

        //Button
        cBtn = findViewById(R.id.checkButton); //initialize check button
        signupBtn = findViewById(R.id.suBtn); //initialize sign up button
        nBtn = findViewById(R.id.nextBtn); //initialize next
        checkBtn = findViewById(R.id.checkButton); //initialize check button
        saveBtn = findViewById(R.id.saveBtn); //initialize save

        //Spinner
        spinner1 = findViewById(R.id.spinner_relations); //initialize spinner relation
        spinner2 = findViewById(R.id.spinner_YoN); //initialize spinner choice

        //EditText
        insertCode = findViewById(R.id.insertCode); //initialize input hearduino code


        //Get text from Intent
        Intent intent = getIntent();
        String getName = intent.getStringExtra("name");
        String getUsername = intent.getStringExtra("username");
        String getCode = intent.getStringExtra("code");

        //Set Text
        name.setText(getName);
        username.setText(getUsername);
        code.setText(getCode);

        //for the choice drop down
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Activity_SignUp2.this, R.layout.relation_list, choice);
        adapter2.setDropDownViewResource(R.layout.relation_list);

        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                String value2 = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(spinner2.getSelectedItem() == "No"){
                    //set visibility to visible
                    cText.setVisibility(View.VISIBLE);
                    insertCode.setVisibility(View.VISIBLE);
                    checkBtn.setVisibility(View.VISIBLE);
                    rText.setVisibility(View.VISIBLE);
                    spinner1.setVisibility(View.VISIBLE);
                    saveBtn.setVisibility(View.VISIBLE);
                } else if(spinner2.getSelectedItem() == " "){
                    Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sign Up Now", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //for the relation drop down
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Activity_SignUp2.this, R.layout.choice_list, relation);
        adapter.setDropDownViewResource(R.layout.choice_list);

        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Activity_SignUp2.this, "Please select an option", Toast.LENGTH_SHORT).show();
            }
        });

        signupBtn.setOnClickListener(v -> openReviewInformation());

    }

    public void openReviewInformation(){
        //get data from views
        String getName = name.getText().toString();
        String getUsername = username.getText().toString();
        String getCode = code.getText().toString();
        String getRelation = spinner1.getSelectedItem().toString();

        //transfer to next activity
        Intent i = new Intent(this, Popout_ReviewInformation.class);
        i.putExtra("name", getName);
        i.putExtra("username", getUsername);
        i.putExtra("code", getCode);
        i.putExtra("relation", getRelation);
        startActivity(i);
    }

}