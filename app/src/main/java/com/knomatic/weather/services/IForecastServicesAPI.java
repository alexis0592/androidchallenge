package com.knomatic.weather.services;

/**
 * Created by alexiscalderon on 4/02/17.
 */

import com.knomatic.weather.model.DTO.ForecastDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IForecastServicesAPI {

    String ENDPOINT = "https://api.darksky.net";

    @GET("/forecast/{key}/{latitude},{longitude}")
    Call<ForecastDTO> getForecast(@Path("key") String apikey, @Path("latitude") String latitude, @Path("longitude") String longitude);

}
