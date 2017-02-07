package com.knomatic.weather.presentation.activities.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.knomatic.weather.R;
import com.knomatic.weather.model.DTO.DailyDataDTO;
import com.knomatic.weather.utils.impl.ForeCastUtils;
import com.knomatic.weather.utils.IForeCastUtils;

import java.util.List;

/**
 * Created by alexiscalderon on 5/02/17.
 */

public class ForecastAdapter extends ArrayAdapter {

    private List<DailyDataDTO> dailyDataDTOs;
    private String[] daysOfWeek;
    private Integer[] indexOfDays;
    private IForeCastUtils foreCastUtils;

    public ForecastAdapter(Context context, List<DailyDataDTO> data){
        super(context, R.layout.list_view_cell, data);
        this.dailyDataDTOs = data;
        this.daysOfWeek = new String[]{"Sunday", "Monday", "Tuesday", "Wedneday", "Thursday", "Friday",
                                            "Saturday","Sunday"};
        this.foreCastUtils = ForeCastUtils.getInstance();
        this.indexOfDays = foreCastUtils.foreCastDays();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_view_cell, null);

        ImageView iconImageView = (ImageView) item.findViewById(R.id.imgViewIcon);
        String mDrawableName = foreCastUtils.convertIconName(dailyDataDTOs.get(position).getIcon());
        iconImageView.setImageResource(convertStringToIntRes(mDrawableName));

        TextView dayTextView = (TextView)item.findViewById(R.id.txtViewDay);
        dayTextView.setText(daysOfWeek[indexOfDays[position]]);

        TextView summaryTextView = (TextView) item.findViewById(R.id.txtViewSummary);
        summaryTextView.setText(dailyDataDTOs.get(position).getSummary());

        TextView minTemperatureTextView = (TextView) item.findViewById(R.id.txtTempMin);
        minTemperatureTextView.setText(String.valueOf(dailyDataDTOs.get(position).getTemperatureMin())
            + "ºF temp min");

        TextView maxTemperatureTextView = (TextView) item.findViewById(R.id.txtViewTempMax);
        maxTemperatureTextView.setText(String.valueOf(dailyDataDTOs.get(position).getTemperatureMax()) +
                "ºF temp max");

        return item;
    }

    /**
     * Method that return int resource from string name, for imageView set
     * @param name
     * @return int value from name
     */
    public int convertStringToIntRes(String name){
        Resources res = getContext().getResources();
        int resID = res.getIdentifier(name, "drawable", getContext().getPackageName());

        return resID;
    }
}
