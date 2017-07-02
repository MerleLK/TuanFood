package com.tuan.DB.domain;

/** 地区表类
 * Created by Administrator on 2017/7/2.
 */
public class District {
    private int districtId;
    private String districtName;
//    private int cityId;
    private String cityName;

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
