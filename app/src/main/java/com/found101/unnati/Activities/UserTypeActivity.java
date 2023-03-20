package com.found101.unnati.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.found101.unnati.R;

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
            intent.putExtra("Role","3");
            startActivity(intent);
        });

        btnEntrepreneur.setOnClickListener(v->{
            Intent intent=new Intent(this,SignUpActivity.class);
            intent.putExtra("Role","4");
            startActivity(intent);
        });

    }
}