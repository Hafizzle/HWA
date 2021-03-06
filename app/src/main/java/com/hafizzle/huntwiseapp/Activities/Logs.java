package com.hafizzle.huntwiseapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hafizzle.huntwiseapp.R;

public class Logs extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_logs:

                    break;
                case R.id.navigation_gear:
                    Intent intent0 = new Intent(Logs.this, Gear.class);
                    startActivity(intent0);
                    break;
                case R.id.navigation_huntcast:
                    Intent intent1 = new Intent(Logs.this, HuntCast.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_map:
                    Intent intent2 = new Intent(Logs.this, Map.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_me:
                    Intent intent3 = new Intent(Logs.this, Me.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

    }
}
