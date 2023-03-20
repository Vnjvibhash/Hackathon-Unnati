package com.found101.unnati.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.found101.unnati.Models.UserModel;
import com.found101.unnati.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    Button register;
    EditText email,password;
    UserModel userModel;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        database = FirebaseDatabase.getInstance();
        mDatabase=database.getReference("Users");

        register= findViewById(R.id.register);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        register.setOnClickListener(v->{
            String emailToText = email.getText().toString();
            if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
                String CurrentString = emailToText;
                String[] separated = CurrentString.split("@");
                userModel=new UserModel(emailToText,password.getText().toString());
                mDatabase.child(separated[0]).setValue(userModel);
                Intent intent= new Intent(this,RegistrationActivity.class);
                intent.putExtra("user",separated[0]);
                intent.putExtra("email",emailToText);
                intent.putExtra("pass",password.getText().toString());
                startActivity(intent);
                finish();
                Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
            } else {
                email.setError("Email format is invalid");
                Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}