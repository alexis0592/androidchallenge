package com.knomatic.weather.presentation.activities.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.knomatic.weather.presentation.activities.fragments.ForecastActivityFragment;
import com.knomatic.weather.presentation.activities.fragments.WeatherActivityFragment;

/**
 * Created by alexiscalderon on 5/02/17.
 */

public class WeatherFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Currently", "Forecast"};

    public WeatherFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch(position){
            case 0:
                fragment = WeatherActivityFragment.newInstance();
                break;
            case 1:
                fragment = ForecastActivityFragment.newInstance();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return this.PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabTitles[position];
    }
}
