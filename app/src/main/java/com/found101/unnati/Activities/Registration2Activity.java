/*
 *
 *   Created by VnjVibhash on 2/22/24, 1:50 AM
 *   Copyright Ⓒ 2024. All rights reserved Ⓒ 2024 http://vivekajee.in/
 *   Last modified: 2/21/24, 11:32 PM
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

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.found101.unnati.R;

public class Registration2Activity extends AppCompatActivity {
    Button verify_otp;
    EditText contact, editOtp;
    String enteredOtp, user, pass, email, contactNumber, username, name, otp, role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        contact = findViewById(R.id.contact_number);
        editOtp = findViewById(R.id.editOtp);
        contactNumber = getIntent().getStringExtra("contact");
        user = getIntent().getStringExtra("user");
        email = getIntent().getStringExtra("email");
        role = getIntent().getStringExtra("Role");
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
            if(enteredOtp.equals("65879")){
                Intent intent = new Intent(this, Registration3Activity.class);
                intent.putExtra("contact", contactNumber);
                intent.putExtra("user", user);
                intent.putExtra("email", email);
                intent.putExtra("Role", role);
                intent.putExtra("pass", pass);
                intent.putExtra("username", username);
                intent.putExtra("otp", otp);
                intent.putExtra("name", name);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Wrong OTP", Toast.LENGTH_SHORT).show();
            }
            Log.d("UserData", enteredOtp);
        });

    }
}