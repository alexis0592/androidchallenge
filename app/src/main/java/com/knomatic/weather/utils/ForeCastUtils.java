package com.knomatic.weather.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by alexiscalderon on 5/02/17.
 */

public class ForeCastUtils implements IForeCastUtils {

    private static ForeCastUtils instance = null;

    private ForeCastUtils(){

    }

    public static ForeCastUtils getInstance(){
        if(instance == null){
            instance = new ForeCastUtils();
        }

        return instance;
    }

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
            case("partly-cloudy-day"):
                nameConverted = "partlycloudyday";
                break;
            case("partly-cloudy-night"):
                nameConverted = "partlycloudynight";
                break;
            default:
                nameConverted = iconName;
                break;
        }

        return nameConverted;
    }

    @Override
    public Integer[] foreCastDays(){

        Integer[] daysOfWeek = new Integer[]{0, 1, 2, 3, 4,5,6,7};

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        daysOfWeek[0] = day;
        daysOfWeek[7] = day;
        for(int i = 1; i < daysOfWeek.length; i++){

            day += 1;
            if(day <= 6){
                daysOfWeek[i] = day;
            }else{
                day = 0;
                daysOfWeek[i] = day;
            }
        }

        return daysOfWeek;
    }


}
