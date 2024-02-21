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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.found101.unnati.Models.UserModel;
import com.found101.unnati.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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