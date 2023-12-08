package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.graphics.RenderNode;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.UUID;

public class Popout_WelcomeToHearduino extends AppCompatActivity {

    Button btnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_welcometohearduino);

        btnhome = findViewById(R.id.homebtn);

        btnhome.setOnClickListener(view -> openLogin());
    }

    public void openLogin(){
        Intent i = new Intent(Popout_WelcomeToHearduino.this, Activity_UserHome.class);
        startActivity(i);
    }
}
