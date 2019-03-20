package com.example.weather.screen;

import android.app.Application;

public class WeatherApplication extends Application {
    private static WeatherApplication sInstance;

    public static WeatherApplication getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
