package com.hafizzle.huntwiseapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.hafizzle.huntwiseapp.Fragments.BlackBearFragment;
import com.hafizzle.huntwiseapp.Fragments.BlacktailDeerFragment;
import com.hafizzle.huntwiseapp.Fragments.CoyoteFragment;
import com.hafizzle.huntwiseapp.Fragments.ElkFragment;
import com.hafizzle.huntwiseapp.Fragments.MooseFragment;
import com.hafizzle.huntwiseapp.Fragments.MuleDeerFragment;
import com.hafizzle.huntwiseapp.Fragments.RabbitFragment;
import com.hafizzle.huntwiseapp.Fragments.SquirrelFragment;
import com.hafizzle.huntwiseapp.Fragments.TurkeyFragment;
import com.hafizzle.huntwiseapp.Fragments.UplandGameFragment;
import com.hafizzle.huntwiseapp.Fragments.ViewPagerAdapter;
import com.hafizzle.huntwiseapp.Fragments.WaterfowlFragment;
import com.hafizzle.huntwiseapp.Fragments.WhitetailDeerFragment;
import com.hafizzle.huntwiseapp.Fragments.WildBoarFragment;
import com.hafizzle.huntwiseapp.R;

public class HuntCast extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_logs:
                    Intent intent0 = new Intent(HuntCast.this, Logs.class);
                    startActivity(intent0);
                    break;
                case R.id.navigation_gear:
                    Intent intent1 = new Intent(HuntCast.this, Gear.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_huntcast:

                    break;
                case R.id.navigation_map:
                    Intent intent2 = new Intent(HuntCast.this, Map.class);
                    startActivity(intent2);
                case R.id.navigation_me:
                    Intent intent3 = new Intent(HuntCast.this, Me.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huntcast);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragments here
        adapter.AddFragment(new WhitetailDeerFragment(), "Whitetail Deer");
        adapter.AddFragment(new WaterfowlFragment(), "Waterfowl");
        adapter.AddFragment(new TurkeyFragment(), "Turkey");
        adapter.AddFragment(new CoyoteFragment(), "Coyote");
        adapter.AddFragment(new UplandGameFragment(), "Upland Game");
        adapter.AddFragment(new WildBoarFragment(), "Wild Boar");
        adapter.AddFragment(new RabbitFragment(), "Rabbit");
        adapter.AddFragment(new SquirrelFragment(), "Squirrel");
        adapter.AddFragment(new BlackBearFragment(), "Black Bear");
        adapter.AddFragment(new ElkFragment(), "Elk");
        adapter.AddFragment(new MooseFragment(), "Moose");
        adapter.AddFragment(new MuleDeerFragment(), "Mule Deer");
        adapter.AddFragment(new BlacktailDeerFragment(), "Blacktail Deer");

        //Adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
