package com.hafizzle.huntwiseapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizzle.huntwiseapp.Adapters.RecyclerViewAdapter;
import com.hafizzle.huntwiseapp.R;
import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callbacks.ThreeHourForecastCallback;
import com.kwabenaberko.openweathermaplib.models.threehourforecast.ThreeHourForecast;

import java.util.ArrayList;

public class CoyoteFragment extends Fragment {
    private ArrayList<String> mDates = new ArrayList<>();
    private ArrayList<String> mMinTemps = new ArrayList<>();
    private ArrayList<String> mMaxTemps = new ArrayList<>();
    View view;
    public CoyoteFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.coyote_fragment, container, false);

        //OpenWeatherMap
        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));
        helper.setUnits(Units.IMPERIAL);

        helper.getThreeHourForecastByGeoCoordinates(42.9634,-85.6681, new ThreeHourForecastCallback() {
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

        return view;
    }

    public void getForecasts(ThreeHourForecast threeHourForecast){
        for (int i=0;i<=8;i++){
            mDates.add(threeHourForecast.getList().get(i).getDt().toString());
            mMinTemps.add(String.valueOf(threeHourForecast.getList().get(i).getMain().getTempMin()));
            mMaxTemps.add(String.valueOf(threeHourForecast.getList().get(i).getMain().getTempMax()));
        }
    }

    public void initRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), mDates, mMinTemps, mMaxTemps);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
