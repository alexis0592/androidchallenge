package com.knomatic.weather.model.DTO;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class CurrentlyDTO {

    private String summary;
    private String icon;
    private String precipType;
    private Double temperature;

    public CurrentlyDTO(String summary, String icon, String precipType, Double temperature){
        this.summary = summary;
        this.icon = icon;
        this.precipType = precipType;
        this.temperature = temperature;
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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
