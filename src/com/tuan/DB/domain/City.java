package com.tuan.DB.domain;

/** citys table object
 * Created by Administrator on 2017/6/25.
 */
public class City {
    private int cityId;
    private String cityName;

    public City(){

    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
