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