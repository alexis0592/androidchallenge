package com.knomatic.weather.controllers.impl;

import android.content.Context;
import android.location.Location;

import com.knomatic.weather.controllers.IWeatherController;
import com.knomatic.weather.utils.impl.GPSUser;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class WeatherController implements IWeatherController {

    private final Context mContext;
    private GPSUser gpsUser;

    public WeatherController(Context context){
        this.mContext = context;
    }

    /**
     * Method that return the user location, based on GPS and Network
     * @return Location
     */
    @Override
    public Location getLocation() {

        this.gpsUser = new GPSUser(this.mContext);

        return gpsUser.getUserLocation();
    }


}
