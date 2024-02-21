package com.found101.unnati.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.found101.unnati.Models.UserModel;
import com.found101.unnati.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    Button register;
    EditText email,password;
    TextView sign_in;
    String role;
    UserModel userModel;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    ImageView passwordToggleImageView, passwordImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        role=getIntent().getStringExtra("Role");

        database = FirebaseDatabase.getInstance();
        mDatabase=database.getReference("Users");

        register= findViewById(R.id.register);
        sign_in= findViewById(R.id.sign_in);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        passwordToggleImageView = findViewById(R.id.passwordToggleImageView);
        passwordImageView = findViewById(R.id.passwordImageView);
        passwordToggleImageView.setOnClickListener(v -> {
            passwordToggleImageView.setVisibility(View.GONE);
            passwordImageView.setVisibility(View.VISIBLE);
            if (password.getTransformationMethod() instanceof PasswordTransformationMethod) {
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            password.setSelection(password.getText().length());
        });
        passwordImageView.setOnClickListener(v -> {
            passwordImageView.setVisibility(View.GONE);
            passwordToggleImageView.setVisibility(View.VISIBLE);
            if (password.getTransformationMethod() instanceof PasswordTransformationMethod) {
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            password.setSelection(password.getText().length());
        });
        register.setOnClickListener(v->{
            String emailToText = email.getText().toString();
            if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
                String CurrentString = emailToText;
                String[] separated = CurrentString.split("@");
                mDatabase.child(separated[0]).setValue(userModel);
                Intent intent= new Intent(this,RegistrationActivity.class);
                intent.putExtra("user",separated[0]);
                intent.putExtra("email",emailToText);
                intent.putExtra("Role",role);
                intent.putExtra("pass",password.getText().toString());
                startActivity(intent);
                finish();
                Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
            } else {
                email.setError("Email format is invalid");
                Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
            }
        });
        sign_in.setOnClickListener(v->{
            Intent intent= new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}