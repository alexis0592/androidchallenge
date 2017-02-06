package com.knomatic.weather.utils;

import android.location.Location;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public interface IGPSUser {

    public Location getUserLocation();

    public void stopUsingGPS();

    public double getLatitude();

    public double getLongitude();

    public boolean canGetLocation();

    public float getAccuracy();
}
