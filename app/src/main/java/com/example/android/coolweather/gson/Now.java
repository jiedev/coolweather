package com.example.android.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 2017/8/8.
 * 建立Now，现在天气状况
 */

public class Now {
    @SerializedName("tem")
    public String temperature;

    @SerializedName("cond")
    public More more;
    public class More {
        @SerializedName("txt")
        public String info;
    }
}
