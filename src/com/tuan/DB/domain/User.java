package com.tuan.DB.domain;

import java.util.Date;

/** 用户表的类
 * Created by Administrator on 2017/6/24.
 */
public class User {

    private int userId;
    private String username;
    private String password;
    private int userAge;
    private Date userBirthday;
    private Float userMoney;
    private String userAddress;
    private int userRoleId;

    public User(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Float getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Float userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }
}
