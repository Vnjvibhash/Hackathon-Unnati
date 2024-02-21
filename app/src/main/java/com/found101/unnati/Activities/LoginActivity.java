package com.found101.unnati.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    ImageView passwordToggleImageView, passwordImageView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    Button loginButton;
    TextView register;
    Session session;

    boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference("Users");

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        passwordToggleImageView = findViewById(R.id.passwordToggleImageView);
        passwordImageView = findViewById(R.id.passwordImageView);

        passwordToggleImageView.setOnClickListener(v -> {
            passwordToggleImageView.setVisibility(View.GONE);
            passwordImageView.setVisibility(View.VISIBLE);
            if (passwordEditText.getTransformationMethod() instanceof PasswordTransformationMethod) {
                passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            passwordEditText.setSelection(passwordEditText.getText().length());
        });
        passwordImageView.setOnClickListener(v -> {
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
        register = findViewById(R.id.register);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session = new Session(LoginActivity.this);
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String[] separated = username.split("@");
                System.out.println(separated[0]);

                if (username.equals("user") && password.equals("password")) {
                    session.saveSession("4");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("Role", "4");
                    startActivity(intent);
                } else if (username.equals("investor") && password.equals("password")) {
                    session.saveSession("3");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("Role", "3");
                    startActivity(intent);
                } else if (username.equals("mentor") && password.equals("password")) {
                    session.saveSession("2");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("Role", "2");
                    startActivity(intent);
                } else if (username.equals("finance") && password.equals("password")) {
                    session.saveSession("1");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("Role", "1");
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UserTypeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}