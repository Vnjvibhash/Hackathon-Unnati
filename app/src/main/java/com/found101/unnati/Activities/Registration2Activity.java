package com.found101.unnati.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.found101.unnati.R;

public class Registration2Activity extends AppCompatActivity {
    Button verify_otp;
    EditText contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        contact=findViewById(R.id.contact_number);
        String z = getIntent().getStringExtra("contact");
        contact.setText(z);
        contact.setEnabled(false);


        verify_otp= findViewById(R.id.verify_otp);
        verify_otp.setOnClickListener(v->{
            Intent intent=new Intent(this,Registration3Activity.class);
            startActivity(intent);
        });

    }
}