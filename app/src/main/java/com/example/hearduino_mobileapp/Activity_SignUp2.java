package com.example.hearduino_mobileapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.util.Objects;
import java.util.ResourceBundle;

public class Activity_SignUp2 extends AppCompatActivity {

    TextView name, email, number;
    Button yBtn, nBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        name = findViewById(R.id.setName); //initialize set name
        email = findViewById(R.id.setEmail); //initialize set email
        number = findViewById(R.id.setNum); //initialize set number
        yBtn = findViewById(R.id.bYes); //initialize yes button
        nBtn = findViewById(R.id.bNo); //initialize no button

        //Get text from Intent
        Intent intent = getIntent();
        String getName = intent.getStringExtra("name");
        String getNumber = intent.getStringExtra("number");
        String getEmail = intent.getStringExtra("email");

        //Set Text
        name.setText(getName);
        number.setText(getNumber);
        email.setText(getEmail);

        yBtn.setOnClickListener(view -> openReviewInformation());
    }

    public void openReviewInformation(){
        //get data from views
        String getName = name.getText().toString();
        String getEmail = email.getText().toString();
        String getNumber = number.getText().toString();

        //transfer to next activity
        Intent i = new Intent(this, Popout_ReviewInformation.class);
        i.putExtra("name", getName);
        i.putExtra("email", getEmail);
        i.putExtra("number", getNumber);

        startActivity(i);
    }
}