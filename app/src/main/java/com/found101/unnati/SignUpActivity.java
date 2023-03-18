package com.found101.unnati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        register= findViewById(R.id.register);
        register.setOnClickListener(v->{
            Intent intent= new Intent(this,RegistrationActivity.class);
            startActivity(intent);
            finish();
        });
    }
}