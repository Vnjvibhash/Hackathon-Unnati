package com.found101.unnati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {
    Button send_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        send_otp= findViewById(R.id.send_otp);
        send_otp.setOnClickListener(v->{
            Intent intent = new Intent(this,Registration2Activity.class);
            startActivity(intent);
        });

    }
}