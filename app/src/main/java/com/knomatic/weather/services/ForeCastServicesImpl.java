package com.knomatic.weather.services;

import android.util.Log;

import com.knomatic.weather.presentation.activities.WeatherActivity;
import com.knomatic.weather.model.DTO.ForecastDTO;
import com.knomatic.weather.presentation.activities.fragments.WeatherActivityFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class ForeCastServicesImpl{

    private Retrofit retrofit;
    private ForecastDTO forecastDTO;

    private static ForeCastServicesImpl foreCastServicesInstance = null;

    private ForeCastServicesImpl(){
    }

    public static ForeCastServicesImpl getInstance(){
        if(foreCastServicesInstance == null){
            foreCastServicesInstance = new ForeCastServicesImpl();
        }

        return foreCastServicesInstance;
    }

    public void setForeCastResponse(ForecastDTO foreCast){
        this.forecastDTO = foreCast;
    }

    public ForecastDTO getForecastDTO(){
        return forecastDTO;
    }




}
