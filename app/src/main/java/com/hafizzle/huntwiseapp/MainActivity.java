package com.hafizzle.huntwiseapp;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_logs:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_gear:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_huntcast:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_map:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_me:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = findViewById(R.id.message);
    }

}
