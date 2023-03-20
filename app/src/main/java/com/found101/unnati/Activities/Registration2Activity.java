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
import android.widget.Toast;

import com.found101.unnati.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Registration2Activity extends AppCompatActivity {
    Button verify_otp;
    EditText contact, editOtp;
    String enteredOtp, user, pass, email, contactNumber, username, name, otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        contact = findViewById(R.id.contact_number);
        editOtp = findViewById(R.id.editOtp);
        contactNumber = getIntent().getStringExtra("contact");
        user = getIntent().getStringExtra("user");
        email = getIntent().getStringExtra("email");
        pass = getIntent().getStringExtra("pass");
        username = getIntent().getStringExtra("username");
        otp = getIntent().getStringExtra("otp");
        name = getIntent().getStringExtra("name");
        contact.setText(contactNumber);
        Log.d("UserData", otp);
        Log.d("UserData", user);


        verify_otp = findViewById(R.id.verify_otp);
        verify_otp.setOnClickListener(v -> {
            enteredOtp = editOtp.getText().toString().trim();
            if(enteredOtp.equals(otp)){
                Intent intent = new Intent(this, Registration3Activity.class);
                intent.putExtra("contact", contactNumber);
                intent.putExtra("user", user);
                intent.putExtra("email", email);
                intent.putExtra("pass", pass);
                intent.putExtra("username", username);
                intent.putExtra("otp", otp);
                intent.putExtra("name", name);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Wrong OTP", Toast.LENGTH_SHORT).show();
            }
            Log.d("UserData", enteredOtp);
//            try {
//                query = mDatabase.orderByChild(enteredOtp).equalTo(enteredOtp);
//                query.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            String otpFromDb = snapshot.child(user).child("otp").getValue(String.class);
//                            if (otpFromDb.equals(enteredOtp)) {
//                                Toast.makeText(Registration2Activity.this, "User Verified", Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(Registration2Activity.this, "User Not Verified", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Log.e("UserData",error.getMessage());
//                    }
//                });
//            } catch (Exception e) {
//                Log.d("UserData", e.getMessage());
//            }

        });

    }
}