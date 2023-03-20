package com.found101.unnati.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.found101.unnati.Models.UserModel;
import com.found101.unnati.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration3Activity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button submit;
    String user, pass, email, contactNumber, username, name, otp, proofType;
    EditText proofId, profession,address;
    UserModel userModel;

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Users");

        contactNumber = getIntent().getStringExtra("contact");
        user = getIntent().getStringExtra("user");
        email = getIntent().getStringExtra("email");
        pass = getIntent().getStringExtra("pass");
        username = getIntent().getStringExtra("username");
        otp = getIntent().getStringExtra("otp");
        name = getIntent().getStringExtra("name");

        submit = findViewById(R.id.submit);
        proofId = findViewById(R.id.proof_id);
        profession = findViewById(R.id.profession);
        address = findViewById(R.id.address);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                proofType= (String) radioButton.getText();
                Toast.makeText(Registration3Activity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(v->{

            if((proofType.equals("Aadhar Card")&&proofId.getText().toString().trim().length()==12)||(proofType.equals("PAN Card")&&proofId.getText().toString().trim().length()==10)){
                userModel=new UserModel(email, pass, username, name, contactNumber, profession.getText().toString().trim(), address.getText().toString().trim(), proofType, proofId.getText().toString().trim(), Integer.valueOf(otp));
                mDatabase.child(user).setValue(userModel);
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(Registration3Activity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Registration3Activity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }else{
                Toast.makeText(this, "Wrong Information Entered", Toast.LENGTH_SHORT).show();
            }

        });


    }

}