package com.found101.unnati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UserTypeActivity extends AppCompatActivity {
    Button btnInvestor,btnEntrepreneur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        btnInvestor=findViewById(R.id.btnInvestor);
        btnEntrepreneur=findViewById(R.id.btnEntrepreneur);

        btnInvestor.setOnClickListener(v->{
            Intent intent=new Intent(this,SignUpActivity.class);
            startActivity(intent);
        });

        btnEntrepreneur.setOnClickListener(v->{
            Intent intent=new Intent(this,SignUpActivity.class);
            startActivity(intent);
        });
    }
}