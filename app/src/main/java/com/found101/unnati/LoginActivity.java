package com.found101.unnati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    ImageView passwordToggleImageView, passwordImageView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        passwordToggleImageView = findViewById(R.id.passwordToggleImageView);
        passwordImageView = findViewById(R.id.passwordImageView);

        passwordToggleImageView.setOnClickListener(v->{
            passwordToggleImageView.setVisibility(View.GONE);
            passwordImageView.setVisibility(View.VISIBLE);
            if (passwordEditText.getTransformationMethod() instanceof PasswordTransformationMethod) {
                passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            passwordEditText.setSelection(passwordEditText.getText().length());
        });
        passwordImageView.setOnClickListener(v->{
            passwordImageView.setVisibility(View.GONE);
            passwordToggleImageView.setVisibility(View.VISIBLE);
            if (passwordEditText.getTransformationMethod() instanceof PasswordTransformationMethod) {
                passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            passwordEditText.setSelection(passwordEditText.getText().length());
        });

        loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("admin") && password.equals("password")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}