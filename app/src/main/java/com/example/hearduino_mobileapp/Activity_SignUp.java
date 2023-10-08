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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class Activity_SignUp extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name, email;
    Button cBtn, sBtn;
    EditText number;
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
        imgview = findViewById(R.id.userIcon); //initialize image view

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);


        //get data from the account which is signed in
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();
            //insert to text view
            name.setText(personName);
            email.setText(personEmail);
            Picasso.get().load(personPhoto).into(imgview);
        }

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

        sBtn.setOnClickListener(view -> openSU2());
    }

    //write on activity result for change photo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            cPic = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cPic);
                imgview.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void openSU2(){
        //get data from views
        String getName = name.getText().toString();
        String getEmail = email.getText().toString();
        String getNumber = number.getText().toString();

        //transfer to next activity
        Intent i = new Intent(this, Activity_SignUp2.class);
        i.putExtra("name", getName);
        i.putExtra("email", getEmail);
        i.putExtra("number", getNumber);
        startActivity(i);
    }

}
