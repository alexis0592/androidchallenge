package com.knomatic.weather.controllers.impl;

import android.content.Context;
import android.location.Location;

import com.knomatic.weather.controllers.IWeatherController;
import com.knomatic.weather.model.DTO.ForecastDTO;
import com.knomatic.weather.services.ForeCastServicesImpl;
import com.knomatic.weather.services.IForecastServicesAPI;
import com.knomatic.weather.utils.GPSUser;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class WeatherController implements IWeatherController {

    private final Context mContext;
    private GPSUser gpsUser;
    private ForecastDTO forecastResponse;
    private ForeCastServicesImpl forecastServicesAPI;

    public WeatherController(Context context){
        this.mContext = context;
    }

    @Override
    public Location getLocation() {

        this.gpsUser = new GPSUser(this.mContext);
        double latitude = this.gpsUser.getLatitude();
        double longitude = this.gpsUser.getLongitude();

        return gpsUser.getUserLocation();
    }

    @Override
    public ForecastDTO callForecastService(String apiKey) {
        this.gpsUser = new GPSUser(this.mContext);
        double latitude = this.gpsUser.getLatitude();
        double longitude = this.gpsUser.getLongitude();

        this.forecastServicesAPI = ForeCastServicesImpl.getInstance();

        //this.forecastServicesAPI.executeRetrofitCall(apiKey, String.valueOf(latitude),
                //String.valueOf(longitude));

        return null;
    }
}
