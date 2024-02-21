/*
 *
 *   Created by VnjVibhash on 2/22/24, 1:50 AM
 *   Copyright Ⓒ 2024. All rights reserved Ⓒ 2024 http://vivekajee.in/
 *   Last modified: 2/22/24, 1:44 AM
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

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.found101.unnati.Fragments.FeedFragment;
import com.found101.unnati.Fragments.HomeFragment;
import com.found101.unnati.Fragments.MessageFragment;
import com.found101.unnati.Fragments.NotificationFragment;
import com.found101.unnati.Fragments.ProfileFragment;
import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    String role;
    Session session;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new Session(this);
        role = getIntent().getStringExtra("Role") != null ? getIntent().getStringExtra("Role") : session.getRole();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        if (role.equals("1")){
            replaceFragment(new MessageFragment(), null);
        }else if(role.equals("2")) {
            replaceFragment(new MessageFragment(), null);
        } else {
            replaceFragment(new HomeFragment(), null);
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home) {
                replaceFragment(new HomeFragment(), null);
                return true;
            } else if (id == R.id.message) {
                Bundle bundle=new Bundle();
                bundle.putString("Title","All Message");
                replaceFragment(new MessageFragment(), bundle);
                return true;
            } else if (id == R.id.feed) {
                replaceFragment(new FeedFragment(), null);
                return true;
            } else if (id == R.id.notification) {
                replaceFragment(new NotificationFragment(), null);
                return true;
            } else if (id == R.id.profile) {
                replaceFragment(new ProfileFragment(), null);
                return true;
            } else {
                return super.onOptionsItemSelected(item);
            }
        });
    }

    private void replaceFragment(Fragment fragment, Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(bundle!=null)
            fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}