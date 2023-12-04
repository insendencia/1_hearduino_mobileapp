package com.example.hearduino_mobileapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_DoorbellHistory extends AppCompatActivity {

    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doorbellhistory);

        menu = findViewById(R.id.menubutton);

        //menu button
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    //menu button
    private void showDialog(){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popout_menu);

        //insert condition for each button
        TextView home = dialog.findViewById(R.id.homebtn);
        TextView cameraFootage = dialog.findViewById(R.id.camerafootagebtn);
        TextView doorbellHistory = dialog.findViewById(R.id.doorbellhistorybtn);
        TextView listRegisterVisitor = dialog.findViewById(R.id.listofregistervisitorsbtn);
        TextView about = dialog.findViewById(R.id.aboutbtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_DoorbellHistory.this, Activity_UserHome.class);
                startActivity(i);
            }
        });

        cameraFootage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_DoorbellHistory.this, Activity_CameraFootage.class);
                startActivity(i);
            }
        });

        doorbellHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_DoorbellHistory.this, Activity_DoorbellHistory.class);
                startActivity(i);
            }
        });

        listRegisterVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Activity_DoorbellHistory.this, Activity_ListOfRegisteredVisitors.class);
                startActivity(j);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_DoorbellHistory.this, Activity_AboutPage.class);
                startActivity(i);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}
