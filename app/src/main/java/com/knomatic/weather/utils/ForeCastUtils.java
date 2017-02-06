package com.knomatic.weather.utils;

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


}
