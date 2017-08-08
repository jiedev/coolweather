package com.example.android.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 2017/8/8.
 * 建立Basic，基本信息
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public  String weatherId;

    public Update update;
    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
