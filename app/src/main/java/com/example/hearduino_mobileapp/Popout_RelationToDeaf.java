package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;

public class Popout_RelationToDeaf extends AppCompatActivity {

    //array
    String[] relation = {"Select Relation", "Parent", "Child", "Sibling", "Friend", "Spouse", "Other"};
    Spinner spinner;

    Button contBtn, canBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_relationtodeaf);

        spinner = findViewById(R.id.spinner_relations); //initialize spinner
        contBtn = findViewById(R.id.cBtn); //initialize continue button
        canBtn = findViewById(R.id.cancelbtn); //initialize cancel button

        //for the drop down
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Popout_RelationToDeaf.this, R.layout.relation_list, relation);
        adapter.setDropDownViewResource(R.layout.relation_list);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Popout_RelationToDeaf.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //set on click listener for continue button
        contBtn.setOnClickListener(view -> openSU2());
        canBtn.setOnClickListener(view -> backtoSU());
    }

    public void openSU2(){
        Intent i = new Intent(this, Activity_SignUp2.class);
        startActivity(i);
    }

    public void backtoSU(){
        Intent j = new Intent(this, Activity_SignUp.class);
        startActivity(j);
    }
}
