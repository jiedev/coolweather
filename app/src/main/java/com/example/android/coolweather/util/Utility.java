package com.example.android.coolweather.util;

import android.text.TextUtils;

import com.example.android.coolweather.db.City;
import com.example.android.coolweather.db.County;
import com.example.android.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/6.
 * 建立Utility，解析和处理服务器返回的JSon数据并将数据加入数据库
 *handleProvince（）方法、handleCity（）方法、handleCounty（）方法
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvince(String response) {
        if(!TextUtils.isEmpty(response)) {
            try{
                JSONArray allProvince = new JSONArray(response);
                for(int i=0;i<allProvince.length();i++) {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }
                return true;
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCity(String response,int provinceId) {
        if(!TextUtils.isEmpty(response)) {
            try{
                JSONArray allCity = new JSONArray(response);
                for(int i=0;i< allCity.length();i++) {
                    JSONObject cityObject = allCity.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCounty(String response,int cityId) {
        if(!TextUtils.isEmpty(response)) {
            try{
                JSONArray allCounty = new JSONArray(response);
                for(int i=0;i< allCounty.length();i++) {
                    JSONObject countyObject = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setCityId(cityId);
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
