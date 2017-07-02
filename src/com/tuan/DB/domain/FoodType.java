package com.tuan.DB.domain;

/** 美食类别表属性
 * Created by Administrator on 2017/7/2.
 */
public class FoodType {

    private int foodTypeId;
    private String foodTypeName;

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }
}
