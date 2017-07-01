package com.tuan.DB.DAO;

import com.tuan.DB.domain.Review;
import java.util.HashMap;
import java.util.List;

/** 店铺管理员的数据库接口
 * Created by Administrator on 2017/6/25.
 */
public interface SellerDAO {

    // 得到当前系统内所有美食分类
    HashMap<String, String> getAllFoodType() throws Exception;

    // 得到当前系统内所有地区
    HashMap<String, String> getAllArea() throws Exception;

    // 检查团购信息是否已经提交审查 todo 考虑如何才是重复
    boolean checkReview(String productName, int productAreaId, int productTypeId) throws Exception;

    // 检查团购信息是否已经发布
    boolean checkProduct(String productName, int productAreaId, int productTypeId) throws Exception;

    // 增加团购信息记录
    boolean addProduct(Review review) throws Exception;

    // 查看当前自己已经发布成功的团购信息
    List<String[]> showAllPublishProduct(int sellerId) throws Exception;

    // 查看审核中的团购信息记录
    List<String[]> showAllReviewProduct(int sellerId) throws Exception;

}
