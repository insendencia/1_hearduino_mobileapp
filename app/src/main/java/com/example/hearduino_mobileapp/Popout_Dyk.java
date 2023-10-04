package com.example.hearduino_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Popout_Dyk extends AppCompatActivity{

    Button yBtn, nBtn; //yes and no buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_dyk);

        yBtn = findViewById(R.id.yBtn); //initialize yes button
        nBtn = findViewById(R.id.nBtn); //initialize no button

        yBtn.setOnClickListener(view -> openRelation());
    }

    public void openRelation(){
        Intent i = new Intent(this, Popout_RelationToDeaf.class);
        startActivity(i);
    }
}
