package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.UUID;

public class Popout_WelcomeToHearduino extends AppCompatActivity {

    TextView hearduinoCode;
    Button btnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_welcometohearduino);

        hearduinoCode = findViewById(R.id.hearduinoCode);
        btnhome = findViewById(R.id.homebtn);

        //unique identifier id
        UUID incCounter = UUID.randomUUID();

        hearduinoCode.setText(incCounter.toString());

        btnhome.setOnClickListener(view -> openLogin());
    }

    public void openLogin(){
        Intent i = new Intent(Popout_WelcomeToHearduino.this, Activity_UserHome.class);
        startActivity(i);
    }
}
