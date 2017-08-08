package com.example.android.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 2017/8/8.
 * 建立Forecast，未来天气
 */

public class Forecast {
    public String date;

    @SerializedName("tem")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature {
        public String max;
        public String min;
    }

    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
