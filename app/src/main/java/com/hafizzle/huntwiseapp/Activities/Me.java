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

public class Me extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_logs:
                    Intent intent0 = new Intent(Me.this, Gear.class);
                    startActivity(intent0);
                    break;
                case R.id.navigation_gear:
                    Intent intent1 = new Intent(Me.this, Gear.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_huntcast:
                    Intent intent2 = new Intent(Me.this, HuntCast.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_map:
                    Intent intent3 = new Intent(Me.this, Map.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_me:

                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }
}
