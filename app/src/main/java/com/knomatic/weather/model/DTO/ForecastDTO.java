package com.knomatic.weather.model.DTO;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class ForecastDTO {

    private String timeZone;
    private CurrentlyDTO currently;
    private DailyDTO daily;

    public ForecastDTO(String timeZone, CurrentlyDTO currently, DailyDTO daily) {
        this.timeZone = timeZone;
        this.currently = currently;
        this.daily = daily;
    }

    public ForecastDTO() {
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public CurrentlyDTO getCurrently() {
        return currently;
    }

    public void setCurrently(CurrentlyDTO currently) {
        this.currently = currently;
    }

    public DailyDTO getDaily() {
        return daily;
    }

    public void setDaily(DailyDTO daily) {
        this.daily = daily;
    }
}
