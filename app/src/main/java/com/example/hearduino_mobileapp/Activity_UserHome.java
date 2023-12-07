package com.example.hearduino_mobileapp;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class Activity_UserHome extends AppCompatActivity {

    //for bluetooth
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSocket bluetoothSocket;
    private OutputStream outputStream;

    private static final String DEVICE_ADDRESS = "01:23:45:67:95:ED"; //BLUETOOTH ADDRESS
    private static final UUID SERIAL_UUID = UUID.fromString("00002A23-0000-1000-8000-00805F9B34FB");

    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_BLUETOOTH_PERMISSION = 1;

    //for the vibration intensity
    private TextView textView;
    private SeekBar seekBar;

    //for batteries
    private ProgressBar pgBar1, pgBar2;
    private TextView pgText1, pgText2;

    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);

        //menu button
        menu = findViewById(R.id.menubutton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        //batteries
        pgBar1 = findViewById(R.id.pgbar1);
        pgBar2 = findViewById(R.id.pgbar2);
        pgText1 = findViewById(R.id.pgtext1);
        pgText2 = findViewById(R.id.pgtext2);

        ////////////////////////////////////////////////////////////////////////////////////////////

        textView = findViewById(R.id.seekbarpercentage);
        seekBar = findViewById(R.id.seekbar);

        // Initialize Bluetooth
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //setup seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText("" + progress + "%");
                //sendIntensityToArduino(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    //menu button
    private void showDialog() {

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
                Intent i = new Intent(Activity_UserHome.this, Activity_UserHome.class);
                startActivity(i);
            }
        });

        cameraFootage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_UserHome.this, Activity_CameraFootage.class);
                startActivity(i);
            }
        });

        doorbellHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_UserHome.this, Activity_DoorbellHistory.class);
                startActivity(i);
            }
        });

        listRegisterVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Activity_UserHome.this, Activity_ListOfRegisteredVisitors.class);
                startActivity(j);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_UserHome.this, Activity_AboutPage.class);
                startActivity(i);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}
