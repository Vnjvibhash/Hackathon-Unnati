package com.found101.unnati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    Button send_otp;
    EditText contact_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        contact_number = findViewById(R.id.contact_number);
        send_otp = findViewById(R.id.send_otp);
        send_otp.setOnClickListener(v -> {
            if (contact_number.getText().toString().trim().length() == 10) {
                Intent intent = new Intent(this, Registration2Activity.class);
                intent.putExtra("contact", contact_number.getText().toString().trim());
                startActivity(intent);
            } else {
                contact_number.setError("Enter the 10 Digit");
            }
        });

    }
}