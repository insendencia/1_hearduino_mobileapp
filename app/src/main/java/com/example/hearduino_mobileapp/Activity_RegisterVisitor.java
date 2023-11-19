package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_RegisterVisitor extends AppCompatActivity {

    EditText name, email, phoneNum, pCode;
    Button nextBtn;

    //spinner for relation
    String[] relations = { " ", "Parent", "Child", "Sibling", "Friend", "Spouse", "Other"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registervisitor);

        name = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        phoneNum = findViewById(R.id.registerPhone);
        pCode = findViewById(R.id.registerCode);
        nextBtn = findViewById(R.id.nextpageBtn);

        //for the relations dropdown
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Activity_RegisterVisitor.this, R.layout.relation_list, relations);
        adapter.setDropDownViewResource(R.layout.relation_list);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String choice = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nextBtn.setOnClickListener(v -> opennextRV());
    }

    public void opennextRV(){
        //Intent i = new Intent(Activity_RegisterVisitor.this, Activity_RegisterVisitor2.class);
        //startActivity(i);
    }
}
