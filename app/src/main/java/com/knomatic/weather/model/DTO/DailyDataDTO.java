package com.knomatic.weather.model.DTO;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class DailyDataDTO {

    private String summary;
    private String icon;
    private String precipType;
    private Double temperatureMin;
    private Double temperatureMax;

    public DailyDataDTO(String summary, String icon, String precipType, Double minTemperature, Double maxTemperature) {
        this.summary = summary;
        this.icon = icon;
        this.precipType = precipType;
        this.temperatureMin = minTemperature;
        this.temperatureMax = maxTemperature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }
}
