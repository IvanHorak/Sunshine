package com.job.ihorak.sunshine;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public static class PlaceholderFragment extends Fragment{

        ArrayAdapter<String> forecastDataAdapter;
        List<String> weekForecast;
        ListView listView;
        View rootView;


        public PlaceholderFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            String[] data = {
                    "Pon 6/23 - Sunčano - 31/17",
                    "Uto 6/24 - Maglovito - 21/8",
                    "Sri 6/25 - Oblačno - 22/17",
                    "Čet 6/26 - Kišovito - 18/11",
                    "Pet 6/27 - Maglovito - 21/10",
                    "Sub 6/28 - SNJEŽOVITO - 23/18"
            };

            weekForecast = new ArrayList<String>(Arrays.asList(data));

            forecastDataAdapter =
                    new ArrayAdapter<String>(
                            getActivity(),
                            R.layout.list_item_forecast,
                            R.id.list_item_forecast_textview,
                            weekForecast);

            rootView = inflater.inflate(R.layout.fragment_main, container, false);

            listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(forecastDataAdapter);
            return rootView;


        }
    }
}
