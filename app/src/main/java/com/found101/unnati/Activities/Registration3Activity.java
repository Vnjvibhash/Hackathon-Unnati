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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registration3Activity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button submit;
    String user, pass, email, contactNumber, username, name, otp, proofType, role;
    EditText proofId, profession, address;
    UserModel userModel;

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

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

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Users");

        contactNumber = getIntent().getStringExtra("contact");
        user = getIntent().getStringExtra("user");
        email = getIntent().getStringExtra("email");
        pass = getIntent().getStringExtra("pass");
        username = getIntent().getStringExtra("username");
        otp = getIntent().getStringExtra("otp");
        name = getIntent().getStringExtra("name");
        role = getIntent().getStringExtra("Role");

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
                proofType = (String) radioButton.getText();
                Toast.makeText(Registration3Activity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
//        UserModel modelList = new UserModel(
//                document.getString("userEmail"),
//                document.getString("userPassword"),
//                document.getString("userName"),
//                document.getString("name"),
//                document.getString("userMobile"),
//                document.getString("profession"),
//                document.getString("address"),
//                document.getString("proofType"),
//                document.getString("idProof"),
//                Integer.valueOf(document.getString("otp")),
//                document.getString("role")
//        );
//        list.add(modelList);
        submit.setOnClickListener(v -> {

            if ((proofType.equals("Aadhar Card") && proofId.getText().toString().trim().length() == 12) || (proofType.equals("PAN Card") && proofId.getText().toString().trim().length() == 10)) {
                userModel = new UserModel(profession.getText().toString().trim(), pass, address.getText().toString().trim(),role, proofId.getText().toString().trim(), contactNumber, proofType, name, otp,email,username);
                mDatabase.child(user).setValue(userModel);

                Intent intent = new Intent(Registration3Activity.this, LoginActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Wrong Information Entered", Toast.LENGTH_SHORT).show();
            }

        });


    }

}