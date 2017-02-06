package com.knomatic.weather.model.DTO;

import java.util.List;

/**
 * Created by alexiscalderon on 4/02/17.
 */

public class DailyDTO {

    private String summary;
    private String icon;
    private List<DailyDataDTO> data;

    public DailyDTO(String summary, String icon, List<DailyDataDTO> listDailyData) {
        this.summary = summary;
        this.icon = icon;
        this.data = listDailyData;
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

    public List<DailyDataDTO> getData() {
        return data;
    }

    public void setData(List<DailyDataDTO> data) {
        this.data = data;
    }
}
