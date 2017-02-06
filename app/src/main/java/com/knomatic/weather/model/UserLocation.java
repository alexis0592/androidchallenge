package com.knomatic.weather.model;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class UserLocation {

    private float lat;
    private float lng;

    public UserLocation(float lat, float lng){
        this.lat = lat;
        this.lng = lng;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
