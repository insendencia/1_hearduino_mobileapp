package com.example.hearduino_mobileapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Activity_SignUp extends AppCompatActivity {

    Button sBtn;
    EditText name, username, code, insertusername, yonText;
    TextView cBtn;
    ImageView imgview;
    private static final int PICK_IMAGE = 1;
    DBHelper DB;

    //spinner for relation
    String[] relation = {" ", "Parent", "Child", "Sibling", "Friend", "Spouse", "Other"};
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sBtn = findViewById(R.id.savebtn); //initialize save button
        cBtn = findViewById(R.id.CHbutton); //initialize change photo button
        name = findViewById(R.id.fullname); //get name
        username = findViewById(R.id.username); //get username
        code = findViewById(R.id.usercode); //initialize passcode
        imgview = findViewById(R.id.userIcon); //initialize image view
        insertusername = findViewById(R.id.insertUName);
        spinner1 = findViewById(R.id.spinner_relations); //initialize spinner relation
        yonText = findViewById(R.id.YoNtext);
        DB = new DBHelper(this);

        //insert photo
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select Photo"), 1);
            }
        });

        //for the relation drop down
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Activity_SignUp.this, R.layout.choice_list, relation);
        adapter.setDropDownViewResource(R.layout.choice_list);

        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        sBtn.setOnClickListener(new View.OnClickListener() {

            String setName = name.getText().toString();
            String setUsername = username.getText().toString();
            String setCode = code.getText().toString();
            String setAnswer = yonText.getText().toString();
            String setAccount = insertusername.getText().toString();
            String setRelation = spinner1.getSelectedItem().toString();
            //Bitmap setImage = cPic.get

            @Override
            public void onClick(View view) {
                openWelcome();
            }
        });
    }

    //write on activity result for change photo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgview.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void openWelcome(){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popout_welcometohearduino);

        Button home = dialog.findViewById(R.id.UHomebtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_SignUp.this, Activity_UserHome.class);
                startActivity(i);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER);

    }
}