package com.tuan.DB.DAO;

import com.tuan.DB.domain.*;

import java.util.HashMap;
import java.util.List;

/** Admin 数据库操作接口
 * Created by Administrator on 2017/6/25.
 */
public interface AdminDAO {
    // 检查城市是否已经录入
    boolean checkCity(String cityName) throws Exception;
    // 添加城市
    boolean addCity(String cityName) throws Exception;
    // 列出所有的城市
    List<String[]> getAllCitys() throws Exception;

    // 得到通过城市ID得到某城市具体信息
    City getCityByCityId(int cityId) throws Exception;

    // 修改城市信息
    boolean editCity(int cityId, String cityName) throws Exception;

    // 检查地区是否已经录入
    boolean checkDistrict(int cityId, String districtName) throws Exception;
    // 添加地区
    boolean addDistrict(int cityId, String districtName) throws Exception;
    // 列出所有地区
    List<String[]> getAllDistricts() throws Exception;
    // 通过地区ID得到地区的详细信息
    District getDistrictByDistrictId(int districtId) throws Exception;
    // 修改地区信息
    boolean editDistrict(int districtId, String districtName, int cityId) throws Exception;

    // 得到所有的城市信息
    HashMap<String, String> getAllCityId() throws Exception;

    // 检测美食类别
    boolean checkFoodType(String foodType) throws Exception;
    // 新增美食类别
    boolean addFoodType(String foodType) throws Exception;
    // 修改美食类别信息
    boolean editFoodType(int foodTypeId, String foodTypeName) throws Exception;
    // 通过美食类别ID得到类别具体信息
    FoodType getFoodTypeById(int  foodTypeId) throws Exception;
    // 查看美食类别
    List<String[]> getAllFoodType() throws Exception;

    // 列出当前还没有审核的团购记录
    List<String[]> getAllReviewWithoutCheck() throws Exception;
    // 某条待审核团购记录的所有信息
    Review getReviewInfo(int reviewId) throws Exception;
    // 审核通过后添加该商品
    boolean addProduct(Review review) throws Exception;

    // 将审核通过的团购记录 在审核表中更新审核状态。
    boolean changeReviewStatus(int reviewId, int reviewStatus) throws Exception;

    // 列出所有的美食
    List<Product> getAllProduct() throws Exception;

}
