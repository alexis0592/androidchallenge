package com.knomatic.weather.utils;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class GPSUser extends Service implements IGPSUser , LocationListener{

    private final Context mContext;
    private boolean isGPSEnabled = false;
    private boolean isNetworkEnabled = false;
    private boolean canGetLocation = false;

    private Location location;
    private double lat;
    private double lng;

    private static final long MIN_DISTANCE_FOR_UPDATES = 10;

    private static final long MIN_TIME_FOR_UPDATES = 1000 * 60;

    protected LocationManager locationManager;

    public GPSUser(Context context){
        this.mContext = context;
        this.getUserLocation();
    }

    @Override
    public Location getUserLocation() {

        try {
            this.locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

            //obtener estado del GPS
            this.isGPSEnabled = this.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            //get network status
            this.isNetworkEnabled = this.locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if(!isGPSEnabled && !isNetworkEnabled){

            }else{
                this.canGetLocation = true;

                if(isNetworkEnabled){
                    try {
                        this.locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_FOR_UPDATES, MIN_DISTANCE_FOR_UPDATES, this);
                        Log.d("Network", "Network");
                        if(this.locationManager != null){
                            this.location = this.locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            if(location != null){
                                this.lat = this.location.getLatitude();
                                this.lng = this.location.getLongitude();
                            }
                        }
                    }catch (SecurityException securityException){
                        Log.d("NetworkException", securityException.getMessage());
                    }

                    if(isGPSEnabled){
                        if(this.location == null){
                            try{
                                this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_FOR_UPDATES, MIN_DISTANCE_FOR_UPDATES, this);
                                Log.d("GPS Enabled", "GPS Enabled");
                                if(this.locationManager != null){
                                    this.location = this.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                    if(location != null){
                                        this.lat = this.location.getLatitude();
                                        this.lng = this.getLongitude();
                                    }
                                }
                            }catch (SecurityException securityException){
                                Log.d("GPSException", securityException.getMessage());
                            }
                        }
                    }
                }
            }

        } catch (Exception e){

        }

        return this.location;
    }

    @Override
    public void stopUsingGPS() {
        if(this.locationManager != null){
            try {
                this.locationManager.removeUpdates(GPSUser.this);
            }catch (SecurityException securityException){
                Log.d("Security Exception", "StopUsingGPS");
            }
        }
    }

    @Override
    public double getLatitude() {
        if (this.location != null){
            this.lat = location.getLatitude();
        }
        return this.lat;
    }

    @Override
    public double getLongitude() {
        if (this.location != null){
            this.lng = location.getLatitude();
        }
        return this.lng;
    }

    @Override
    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    @Override
    public void onLocationChanged(Location location) {
        float bestAccuracy = -1f;
        if(this.location.getAccuracy() != 0.0f && (this.location.getAccuracy() < bestAccuracy) || (bestAccuracy == -1f)){
            try {
                this.locationManager.removeUpdates(GPSUser.this);
            }catch (SecurityException securityException){
                Log.d("Security Exception", "onLocationChanged");
            }
        }

    }

    @Override
    public float getAccuracy() {
        return this.location.getAccuracy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

}
