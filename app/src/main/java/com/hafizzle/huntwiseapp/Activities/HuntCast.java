package com.hafizzle.huntwiseapp.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.hafizzle.huntwiseapp.Adapters.RecyclerViewAdapter;
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
import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callbacks.ThreeHourForecastCallback;
import com.kwabenaberko.openweathermaplib.models.threehourforecast.ThreeHourForecast;

import java.util.ArrayList;

public class HuntCast extends AppCompatActivity {
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    //private ArrayList<String> mDates = new ArrayList<>();
    //private ArrayList<String> mMinTemps = new ArrayList<>();
    //private ArrayList<String> mMaxTemps = new ArrayList<>();

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
                    if (isServicesOK()){
                        startActivity(intent2);
                    }else{
                        break;
                    }
                    break;
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


        /*
        //OpenWeatherMap
        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));
        helper.setUnits(Units.IMPERIAL);

        helper.getThreeHourForecastByGeoCoordinates(41.520557,-88.150558, new ThreeHourForecastCallback() {
            @Override
            public void onSuccess(ThreeHourForecast threeHourForecast) {

                getForecasts(threeHourForecast);
                initRecyclerView();

                Log.v("TAG", "City/Country: "+ threeHourForecast.getCity().getName() + "/" + threeHourForecast.getCity().getCountry() +"\n"
                        +"Forecast Array Count: " + threeHourForecast.getCnt() +"\n"
                        //For this example, we are logging details of only the first forecast object in the forecasts array
                        +"First Forecast Date Timestamp: " + threeHourForecast.getList().get(0).getDt() +"\n"
                        +"First Forecast Weather Description: " + threeHourForecast.getList().get(0).getWeatherArray().get(0).getDescription()+ "\n"
                        +"First Forecast Min Temperature: " + threeHourForecast.getList().get(0).getMain().getTempMin()+"\n"
                        +"First Forecast Max Temperature: " + threeHourForecast.getList().get(0).getMain().getTempMax()+"\n"
                        +"First Forecast Wind Speed: " + threeHourForecast.getList().get(0).getWind().getSpeed() + "\n"
                );
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v("TAG", throwable.getMessage());
            }
        });
        */


    }



    /*
    public void getForecasts(ThreeHourForecast threeHourForecast){
        for (int i=0;i<=8;i++){
            mDates.add(threeHourForecast.getList().get(i).getDt().toString());
            mMinTemps.add(String.valueOf(threeHourForecast.getList().get(i).getMain().getTempMin()));
            mMaxTemps.add(String.valueOf(threeHourForecast.getList().get(0).getMain().getTempMax()));
        }
    }

    public void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mDates, mMinTemps, mMaxTemps);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    */

    public boolean isServicesOK(){
        Log.d("TAG", "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(HuntCast.this);
        if(available == ConnectionResult.SUCCESS){
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(HuntCast.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else {
            Toast.makeText(this, "Unable to make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
