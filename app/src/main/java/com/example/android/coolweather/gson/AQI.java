package com.example.android.coolweather.gson;

/**
 * Created by lenovo on 2017/8/8.
 *建立AQI，空气质量
 */

public class AQI {
    public AQICity city;
    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
