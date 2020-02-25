package com.hafizzle.huntwiseapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hafizzle.huntwiseapp.R;

public class Gear extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_logs:
                    Intent intent0 = new Intent(Gear.this, Logs.class);
                    startActivity(intent0);
                    break;
                case R.id.navigation_gear:

                    break;
                case R.id.navigation_huntcast:
                    Intent intent1 = new Intent(Gear.this, HuntCast.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_map:
                    Intent intent2 = new Intent(Gear.this, Map.class);
                    startActivity(intent2);
                case R.id.navigation_me:
                    Intent intent3 = new Intent(Gear.this, Me.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gear);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

    }


}
