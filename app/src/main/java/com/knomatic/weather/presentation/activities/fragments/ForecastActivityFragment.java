package com.knomatic.weather.presentation.activities.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.knomatic.weather.R;
import com.knomatic.weather.controllers.impl.WeatherController;
import com.knomatic.weather.model.DTO.ForecastDTO;
import com.knomatic.weather.presentation.activities.adapters.ForecastAdapter;
import com.knomatic.weather.services.ForeCastServicesImpl;
import com.knomatic.weather.services.IForecastServicesAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexiscalderon on 5/02/17.
 */

public class ForecastActivityFragment extends Fragment {

    private ListView forecastItemsListView;
    private ForeCastServicesImpl foreCastServices;
    private WeatherController weatherController;
    private ForeCastServicesImpl foreCastServicesInstance;
    private Retrofit retrofit;

    public static ForecastActivityFragment newInstance(){
        ForecastActivityFragment forecastActivityFragment = new ForecastActivityFragment();
        return forecastActivityFragment;
    }

    public ForecastActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        initComponents(view);
        executeDarkSkyCall();
        return view;
    }

    private void initComponents(View view){

        this.forecastItemsListView = (ListView) view.findViewById(R.id.listViewforecastItems);

    }


    public void executeDarkSkyCall(){
        weatherController = new WeatherController(this.getContext());
        foreCastServicesInstance = ForeCastServicesImpl.getInstance();

        this.retrofit = new Retrofit.Builder().baseUrl(IForecastServicesAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create()).build();

        IForecastServicesAPI forecastServicesAPI = retrofit.create(IForecastServicesAPI.class);

        Call<ForecastDTO> call = forecastServicesAPI.getForecast(getString(R.string.darksky_API_key),
                String.valueOf(weatherController.getLocation().getLatitude()),
                String.valueOf(weatherController.getLocation().getLongitude()));
        call.enqueue(new Callback<ForecastDTO>() {
            @Override
            public void onResponse(Call<ForecastDTO> call, Response<ForecastDTO> response) {
                foreCastServicesInstance.setForeCastResponse(response.body());

                ForecastAdapter forecastAdapter = new ForecastAdapter(getContext(),
                        response.body().getDaily().getData());

                forecastItemsListView.setAdapter(forecastAdapter);
            }

            @Override
            public void onFailure(Call<ForecastDTO> call, Throwable t) {
                Toast.makeText(getContext(),"There was a problem with the service. Please Try again",
                        Toast.LENGTH_LONG);
            }
        });
    }
}
