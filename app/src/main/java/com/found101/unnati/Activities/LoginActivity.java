package com.found101.unnati.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.found101.unnati.Models.UserModel;
import com.found101.unnati.Models.Users;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    ImageView passwordToggleImageView, passwordImageView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    Button loginButton;
    TextView register;
    Session session;

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Users");

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
                String CurrentString = username;
                String[] separated = CurrentString.split("@");
                System.out.println(separated[0]);
//                mDatabase.child(separated[0]).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        // Get the userModel object from the DataSnapshot
//                        System.out.println("Name: " + dataSnapshot.getValue());
////                        for (DataSnapshot child : dataSnapshot.getChildren()) {
////                            System.out.println("Age: " + child);
////                        }
//                        Users user = dataSnapshot.getChildren();
////                        System.out.println("Age: " + user);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        System.err.println("Data could not be read: " + databaseError.getMessage());
//                    }
//                });
//                mDatabase.child("users").child(separated[0]).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DataSnapshot> task) {
//                        if (!task.isSuccessful()) {
//                            Log.e("firebase", "Error getting data", task.getException());
//                        }
//                        else {
//                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                        }
//                    }
//                });

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
        finish();
    }
}