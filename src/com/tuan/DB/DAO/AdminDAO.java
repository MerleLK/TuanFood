package com.tuan.DB.DAO;

import com.tuan.DB.domain.Product;
import com.tuan.DB.domain.Review;

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

    // 检查地区是否已经录入
    boolean checkDistrict(int cityId, String districtName) throws Exception;
    // 添加地区
    boolean addDistrict(int cityId, String districtName) throws Exception;
    // 列出所有地区
    List<String[]> getAllDistricts() throws Exception;
    // 列出所有的城市ID
    HashMap<String, String> getAllCityId() throws Exception;

    // 检测美食类别
    boolean checkFoodType(String foodType) throws Exception;
    // 新增美食类别
    boolean addFoodType(String foodType) throws Exception;
    // 查看美食类别
    List<String[]> getAllFoodType() throws Exception;

    // 列出当前还没有审核的团购记录
    List<String[]> getAllReviewWithoutCheck() throws Exception;
    // 某条待审核团购记录的所有信息
    Review getReviewInfo(int reviewId) throws Exception;
    // 审核通过后添加该商品
    boolean addProduct(Review review) throws Exception;

    // 列出所有审核团购发布记录  todo

    // 将审核通过的团购记录 在审核表中更新审核状态。
    boolean changeReviewStatus(int reviewId, int reviewStatus) throws Exception;

    // 列出所有的美食
    List<Product> getAllProduct() throws Exception;

}
