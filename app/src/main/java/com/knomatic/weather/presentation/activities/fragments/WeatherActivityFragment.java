package com.knomatic.weather.presentation.activities.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.knomatic.weather.R;
import com.knomatic.weather.controllers.impl.WeatherController;
import com.knomatic.weather.model.DTO.ForecastDTO;
import com.knomatic.weather.presentation.activities.WeatherActivity;
import com.knomatic.weather.services.ForeCastServicesImpl;
import com.knomatic.weather.services.IForecastServicesAPI;
import com.knomatic.weather.utils.ForeCastUtils;
import com.knomatic.weather.utils.IForeCastUtils;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class WeatherActivityFragment extends Fragment implements Callback<ForecastDTO>{

    private ImageView iconImageView;
    private TextView summaryTextView;
    private TextView precipirTypeTextView;
    private TextView temperatureTextView;
    private Retrofit retrofit;
    private ForecastDTO forecastDTO;
    private WeatherController weatherController;
    private ForeCastServicesImpl foreCastServicesInstance;
    private IForeCastUtils foreCastUtils;

    public static WeatherActivityFragment newInstance(){
        WeatherActivityFragment weatherActivityFragment = new WeatherActivityFragment();
        return weatherActivityFragment;
    }

    public WeatherActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        initComponents(view);
        executeDarkSkyCall();

        return view;
    }

    private void initComponents(View view){
        this.iconImageView = (ImageView) view.findViewById(R.id.image_view_icon);
        this.summaryTextView = (TextView)view.findViewById(R.id.text_view_summary);
        this.precipirTypeTextView = (TextView) view.findViewById(R.id.textViewPrecipipType);
        this.temperatureTextView = (TextView) view.findViewById(R.id.txtViewTemp);
    }

    public void setComponents(ForecastDTO forecastDTO){
        summaryTextView = (TextView) getActivity().findViewById(R.id.text_view_summary);
        summaryTextView.setText(forecastDTO.getCurrently().getSummary());
    }


    public void executeDarkSkyCall(){
        weatherController = new WeatherController(this.getContext());
        foreCastServicesInstance = ForeCastServicesImpl.getInstance();
        foreCastUtils = new ForeCastUtils();


        this.retrofit = new Retrofit.Builder().baseUrl(IForecastServicesAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create()).build();

        IForecastServicesAPI forecastServicesAPI = retrofit.create(IForecastServicesAPI.class);

        Call<ForecastDTO> call = forecastServicesAPI.getForecast(getString(R.string.darksky_API_key),
                String.valueOf(weatherController.getLocation().getLatitude()),
                String.valueOf(weatherController.getLocation().getLongitude()));
        call.enqueue(new Callback<ForecastDTO>() {
            @Override
            public void onResponse(Call<ForecastDTO> call, Response<ForecastDTO> response) {
                foreCastServicesInstance.setForeCastResponse(response.body());

                Resources res = getResources();
                String mDrawableName = foreCastUtils.convertIconName(response.body().getCurrently().getIcon());
                iconImageView.setImageResource(convertStringToIntRes(mDrawableName));

                summaryTextView.setText(response.body().getCurrently().getSummary());
                precipirTypeTextView.setText(response.body().getCurrently().getPrecipType());
                temperatureTextView.setText(response.body().getCurrently().getTemperature() + "º");
            }

            @Override
            public void onFailure(Call<ForecastDTO> call, Throwable t) {
                Toast.makeText(getContext(),"Thera was a problem with the service. Please Try again",
                        Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public void onResponse(Call<ForecastDTO> call, Response<ForecastDTO> response) {

    }

    @Override
    public void onFailure(Call<ForecastDTO> call, Throwable t) {

    }

    public int convertStringToIntRes(String name){
        Resources res = getResources();
        int resID = res.getIdentifier(name, "drawable", getContext().getPackageName());

        return resID;
    }

}
