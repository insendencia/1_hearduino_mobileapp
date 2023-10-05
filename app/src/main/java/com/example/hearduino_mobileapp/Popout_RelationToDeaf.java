package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Popout_RelationToDeaf extends AppCompatActivity {

    Button cBtn, bBtn; //continue and back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_relationtodeaf);

        cBtn = findViewById(R.id.contBtn); //initialize continue button
        bBtn = findViewById(R.id.bBUTTON); //initialize back button

        cBtn.setOnClickListener(view -> openNextQ()); //opens next questions
    }

    public void openNextQ(){
        Intent i = new Intent(this, Popout_AskForAccount.class);
        startActivity(i);
    }
}
