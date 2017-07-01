package com.tuan.DB.DAO;

import com.tuan.DB.domain.Product;

import java.util.List;

/** 用户角色的数据库操作接口
 * Created by Administrator on 2017/6/28.
 */
public interface CustomerDAO {

    // 通过城市ID 得到城市名
    String getCityNameByCityId(int cityId) throws Exception;

    // 通过城市ID 得到该城市下所有的地区下所有的美食
    List<Product> getAllProductByCityId(int cityId) throws Exception;

    // 通过城市ID 得到该城市所有的地区ID  字符型
    List<String> getAllDistrictByCityId(int cityId) throws Exception;

    // 依据价格和城市ID得到美食的顺序排列(参数包括 ) 降序
    List<Product> getSoftProductByCityId(int cityId) throws Exception;

    // 依据价格区间和城市ID得到该城市下所有的美食
    List<Product> getAllProductByCityIdAndPrice(int cityId, Float lowPrice, Float highPrice) throws Exception;

    // 依据商品ID得到商品的具体信息
    Product getProductInfo(int productId) throws Exception;

    // 通过商品ID添加到订单表
    boolean addProductToOrder(int userId, int productId) throws Exception;

    // 通过用户ID得到其所有的订单的信息
    List<Product> getAllProductUserBuy(int userId) throws Exception;

    // 通过用户ID得到其所有的订单ID中的商品ID
    List<String> getAllProductIdUserBuy(int userId) throws Exception;

    // 通过分类ID和城市ID得到所有的团购信息
    List<Product> getAllProductByTypeAndCity(int cityId, int foodTypeId) throws Exception;

    // 购买商品时，将余额减去价钱 并给店铺管理员增加钱数。
    boolean changeMoneyBuyProduct(int userId, int productId) throws Exception;

    // 通过用户Id得到用户的余额
    float getMoneyByUserId(int userId) throws Exception;

    // 更新用户余额
    boolean updateMoneyByUserId(int userId, float money) throws Exception;

    // 通过商品ID得到商品的库存和余量
    List<String> getInventoryAndSoldAmount(int productId) throws Exception;

    // 通过商品ID更新新库存和新余量
    boolean updateInventoryAndSoldAmoubt(int productId, int ven, int soldAmount) throws Exception;
}
