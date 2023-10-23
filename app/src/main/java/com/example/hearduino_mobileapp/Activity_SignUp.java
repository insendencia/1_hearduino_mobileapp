package com.example.hearduino_mobileapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Activity_SignUp extends AppCompatActivity {

    TextView name, email;
    Button cBtn, sBtn;
    EditText number, code;
    ImageView imgview;
    Uri cPic;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sBtn = findViewById(R.id.savebtn); //initialize save button
        cBtn = findViewById(R.id.CHbutton); //initialize change photo button
        name = findViewById(R.id.username); //get name
        email = findViewById(R.id.useremail); //get email
        number = findViewById(R.id.userphone); //get phone number
        code = findViewById(R.id.usercode); //initialize passcode
        imgview = findViewById(R.id.userIcon); //initialize image view

        //change photo
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select Photo"), PICK_IMAGE);
            }
        });

        sBtn.setOnClickListener(view -> openSignUp2());
    }

    //write on activity result for change photo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            cPic = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cPic);
                imgview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openSignUp2(){
        //get data from views
        String getName = name.getText().toString();
        String getEmail = email.getText().toString();
        String getNumber = number.getText().toString();
        String getCode = code.getText().toString();

        //transfer to next activity
        Intent i = new Intent(this, Activity_SignUp2.class);
        i.putExtra("name", getName);
        i.putExtra("email", getEmail);
        i.putExtra("number", getNumber);
        i.putExtra("code", getCode);
        startActivity(i);
    }
}