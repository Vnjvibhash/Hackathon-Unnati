/*
 *
 *   Created by VnjVibhash on 2/22/24, 1:50 AM
 *   Copyright Ⓒ 2024. All rights reserved Ⓒ 2024 http://vivekajee.in/
 *   Last modified: 2/22/24, 12:21 AM
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

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
    EditText contact_number,username,name;
    UserModel userModel;
    String user,email,pass,generatedOtp, role;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        database = FirebaseDatabase.getInstance();
        mDatabase=database.getReference("Users");

        user=getIntent().getStringExtra("user");
        role=getIntent().getStringExtra("Role");
        email=getIntent().getStringExtra("email");
        pass=getIntent().getStringExtra("pass");

        username = findViewById(R.id.username);
        name = findViewById(R.id.name);
        contact_number = findViewById(R.id.contact_number);
        send_otp = findViewById(R.id.send_otp);
        generatedOtp=generateOTP();

        send_otp.setOnClickListener(v -> {
            if (!username.getText().toString().isEmpty() && !name.getText().toString().isEmpty() && contact_number.getText().toString().trim().length() == 10) {
                Intent intent = new Intent(this, Registration2Activity.class);
                intent.putExtra("user", user);
                intent.putExtra("Role", role);
                intent.putExtra("email", email);
                intent.putExtra("pass", pass);
                intent.putExtra("username", username.getText().toString().trim());
                intent.putExtra("name", name.getText().toString().trim());
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