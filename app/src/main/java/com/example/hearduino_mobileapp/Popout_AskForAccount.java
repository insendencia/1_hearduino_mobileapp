package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Popout_AskForAccount extends AppCompatActivity {

    Button yBtn, nBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_askforaccount);

        yBtn = findViewById(R.id.yesBtn); //initialize yes button
        nBtn = findViewById(R.id.noBtn); //initialize no button

        yBtn.setOnClickListener(view -> openAskForCode());
    }

    public void openAskForCode(){
        Intent i = new Intent (this, Popout_AskForCode.class);
        startActivity(i);
    }
}
