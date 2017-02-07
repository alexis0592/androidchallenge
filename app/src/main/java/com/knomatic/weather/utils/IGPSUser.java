package com.knomatic.weather.utils;

import android.location.Location;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public interface IGPSUser {

     Location getUserLocation();

     void stopUsingGPS();

     double getLatitude();

     double getLongitude();

     boolean canGetLocation();

     float getAccuracy();
}
