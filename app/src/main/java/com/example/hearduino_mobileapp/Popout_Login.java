package com.example.hearduino_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Popout_Login extends AppCompatActivity {

    Button btn;
    DBHelper DB;
    EditText email, code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.popout_login);

        //initialize button
        btn = findViewById(R.id.loginwgoogle);

        //initialize edit text
        email = findViewById(R.id.typeEmail);
        code = findViewById(R.id.typePasscode);

        //initialize database
        DB = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email.getText().toString();
                String Code = code.getText().toString();

                if(Email.equals("")|| Code.equals("")){
                    Toast.makeText(Popout_Login.this,"Please fill in all credentials", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkEmailCode = DB.checkEmailCode(Email, Code);

                    if(checkEmailCode == true){
                        Toast.makeText(Popout_Login.this, "Welcome!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Activity_UserHome.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Popout_Login.this,"Invalid email/passcode", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
