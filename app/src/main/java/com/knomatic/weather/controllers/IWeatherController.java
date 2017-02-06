package com.knomatic.weather.controllers;

import android.location.Location;

import com.knomatic.weather.model.DTO.ForecastDTO;
import com.knomatic.weather.model.UserLocation;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public interface IWeatherController {

    public Location getLocation();

    public ForecastDTO callForecastService(String apiKey);

}
