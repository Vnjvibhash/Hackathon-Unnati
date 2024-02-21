package com.found101.unnati.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.found101.unnati.R;
import com.found101.unnati.Utils.Session;

public class SplashActivity extends AppCompatActivity {
    TextView app_name;
    private static final int SPLASH_TIME_OUT_HINDI = 2000;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        app_name = findViewById(R.id.app_name);

        session = new Session(this);

        int SPLASH_TIME_OUT = 2000;
        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */
        new Handler().postDelayed(() -> {
            app_name.setText("उन्नति");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(!session.getSession()) {
                        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                }
            }, SPLASH_TIME_OUT_HINDI);
        }, SPLASH_TIME_OUT);
    }
}