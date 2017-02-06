package com.knomatic.weather.utils;

import java.util.Calendar;

/**
 * Created by alexiscalderon on 5/02/17.
 */

public class ForeCastUtils implements IForeCastUtils {

    @Override
    public String convertIconName(String iconName) {

        String nameConverted;

        switch (iconName){
            case("clear-day"):
                nameConverted = "clearday";
                break;
            case("clear-night"):
                nameConverted = "clearnight";
                break;
            case("party-cloudy-day"):
                nameConverted = "partycloudyday";
                break;
            case("party-cloudy-night"):
                nameConverted = "partycloudynight";
                break;
            default:
                nameConverted = iconName;
                break;
        }

        return nameConverted;
    }

    public String[] foreCastDays(){

        String[] daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
        "Saturday", "Sunday"};

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        for(int i = 0; i < daysOfWeek.length; i++){
            //daysOfWeek[i] = daysOfWeek
        }

        return null;
    }


}
