package com.example.hearduino_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.time.Instant;
import java.time.temporal.TemporalAdjuster;

public class Activity_SignUp2 extends AppCompatActivity {

    private Instant Picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        GoogleSignInOptions gso;
        GoogleSignInClient gsc;

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        //get data from the account which is signed in
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            Uri personPhoto = acct.getPhotoUrl();
            //insert to image view
            Picasso.get().load(personPhoto).into(R.id.userIcon);
        }
    }
}