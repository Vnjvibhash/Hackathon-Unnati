package com.found101.unnati.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.found101.unnati.Models.UserModel;
import com.found101.unnati.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    Button send_otp;
    EditText contact_number,username,location;
    UserModel userModel;
    String user,email,pass,generatedOtp;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

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

        database = FirebaseDatabase.getInstance();
        mDatabase=database.getReference("Users");

        user=getIntent().getStringExtra("user");
        email=getIntent().getStringExtra("email");
        pass=getIntent().getStringExtra("pass");

        username = findViewById(R.id.username);
        location = findViewById(R.id.location);
        contact_number = findViewById(R.id.contact_number);
        send_otp = findViewById(R.id.send_otp);
        generatedOtp=generateOTP();

        send_otp.setOnClickListener(v -> {
            if (!username.getText().toString().isEmpty() && !location.getText().toString().isEmpty() && contact_number.getText().toString().trim().length() == 10) {
                userModel=new UserModel(email,pass,username.getText().toString().trim(),location.getText().toString().trim(),contact_number.getText().toString().trim(),Integer.valueOf(generatedOtp));
                mDatabase.child(user).setValue(userModel);
                Intent intent = new Intent(this, Registration2Activity.class);
                intent.putExtra("user", user);
                intent.putExtra("email", email);
                intent.putExtra("pass", pass);
                intent.putExtra("username", username.getText().toString().trim());
                intent.putExtra("location", location.getText().toString().trim());
                intent.putExtra("otp", generatedOtp);
                intent.putExtra("contact", contact_number.getText().toString().trim());
                startActivity(intent);
            } else {
                contact_number.setError("Enter the 10 Digit");
            }
        });
    }

    public static String generateOTP(){
        int randomPin   =(int) (Math.random()*90000)+10000;
        String otp  = String.valueOf(randomPin);
        return otp;
    }
}