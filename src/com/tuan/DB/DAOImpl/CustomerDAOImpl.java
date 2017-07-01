package com.tuan.DB.DAOImpl;

import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DBManager.DatabaseConnection;
import com.tuan.DB.domain.Product;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/** 用户角色的数据库操作具体实现
 * Created by Administrator on 2017/6/28.
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public String getCityNameByCityId(int cityId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String cityName = "";
        String getCityNameSql = "SELECT CITY_NAME FROM CITYS WHERE CITY_ID=?";
        PreparedStatement stmt = con.prepareStatement(getCityNameSql);
        stmt.setInt(1, cityId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
             cityName = rs.getString("city_name");
        }
        return cityName;
    }

    @Override
    // 通过城市ID 得到该城市下所有的地区下所有的美食 类实例数组
    public List<Product> getAllProductByCityId(int cityId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String> districtIds = getAllDistrictByCityId(cityId);  // 地区ID

        List<Product> Products = new ArrayList<>();  // 产品类的集合
        for (String districtId : districtIds){

            String getProductByCityId = "SELECT * FROM PRODUCTS WHERE PRODUCT_AREA=? ORDER BY PRODUCT_PRICE ASC ";
            PreparedStatement stmt = con.prepareStatement(getProductByCityId);
            stmt.setInt(1, Integer.valueOf(districtId));
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            while (rs.next()){
                Product product = new Product();   // 产品类
                for (int i=0; i< resultSetMetaData.getColumnCount(); i++){
                    product.setProductId(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPic(rs.getString("product_pic"));
                    product.setProductPrice(rs.getFloat("product_price"));
                    product.setProductPriceOrigin(rs.getFloat("product_price_origin"));
                    product.setProductArea(rs.getInt("product_area"));
                    product.setProductType(rs.getInt("product_type"));
                    product.setProductInventory(rs.getInt("product_inventory"));
                    product.setProductSellAmount(rs.getInt("product_sell_amount"));
                    product.setProductDeadLine(rs.getDate("product_deadline"));
                    product.setProductSummary(rs.getString("product_summary"));
                    product.setProductDetail(rs.getString("product_details"));
                    product.setSellerId(rs.getInt("seller_id"));
                }
                Products.add(product);
            }

            rs.close();
        }

        return Products;
    }

    @Override
    // 通过城市ID 得到该城市所有的地区
    public List<String> getAllDistrictByCityId(int cityId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String> districtIds = new ArrayList<>();
        String getDistrictByCityIdSql = "SELECT DISTRICT_ID FROM DISTRICTS WHERE CITY_ID=?";
        PreparedStatement stmt = con.prepareStatement(getDistrictByCityIdSql);
        stmt.setInt(1, cityId);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            String districtId = String.valueOf(rs.getInt("DISTRICT_ID"));
            districtIds.add(districtId);
        }
        return districtIds;
    }

    @Override
    // 依据价格和城市ID得到美食的顺序排列(参数包括 降序)
    public List<Product> getSoftProductByCityId(int cityId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String> districtIdss = getAllDistrictByCityId(cityId);  // 地区ID

        List<Product> Products = new ArrayList<>();  // 产品类的集合
        for (String districtId : districtIdss){
            String getProductByCityId = "SELECT * FROM PRODUCTS WHERE PRODUCT_AREA=? ORDER BY PRODUCT_PRICE DESC";
            PreparedStatement stmt = con.prepareStatement(getProductByCityId);
            stmt.setInt(1, Integer.valueOf(districtId));
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            while (rs.next()){
                Product product = new Product();   // 产品类
                for (int i=0; i< resultSetMetaData.getColumnCount(); i++){
                    product.setProductId(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPic(rs.getString("product_pic"));
                    product.setProductPrice(rs.getFloat("product_price"));
                    product.setProductPriceOrigin(rs.getFloat("product_price_origin"));
                    product.setProductArea(rs.getInt("product_area"));
                    product.setProductInventory(rs.getInt("product_inventory"));
                    product.setProductType(rs.getInt("product_type"));
                    product.setProductSellAmount(rs.getInt("product_sell_amount"));
                    product.setProductDeadLine(rs.getDate("product_deadline"));
                    product.setProductSummary(rs.getString("product_summary"));
                    product.setProductDetail(rs.getString("product_details"));
                    product.setSellerId(rs.getInt("seller_id"));
                }
                Products.add(product);
            }
        }
        return Products;
    }

    @Override
    // 依据价格区间和城市ID得到该城市下所有的美食
    public List<Product> getAllProductByCityIdAndPrice(int cityId, Float lowPrice, Float highPrice) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String> districtIdss = getAllDistrictByCityId(cityId);  // 地区ID

        List<Product> Products = new ArrayList<>();  // 产品类的集合
        for (String districtId : districtIdss){
            String getProductByCityId = "SELECT * FROM PRODUCTS WHERE PRODUCT_AREA=? AND PRODUCT_PRICE>? AND PRODUCT_PRICE<?";
            PreparedStatement stmt = con.prepareStatement(getProductByCityId);
            stmt.setInt(1, Integer.valueOf(districtId));
            stmt.setFloat(2, lowPrice);
            stmt.setFloat(3, highPrice);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            while (rs.next()){
                Product product = new Product();   // 产品类
                for (int i=0; i<rsMeta.getColumnCount(); i++){
                    product.setProductId(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPic(rs.getString("product_pic"));
                    product.setProductPrice(rs.getFloat("product_price"));
                    product.setProductPriceOrigin(rs.getFloat("product_price_origin"));
                    product.setProductArea(rs.getInt("product_area"));
                    product.setProductType(rs.getInt("product_type"));
                    product.setProductInventory(rs.getInt("product_inventory"));
                    product.setProductSellAmount(rs.getInt("product_sell_amount"));
                    product.setProductDeadLine(rs.getDate("product_deadline"));
                    product.setProductSummary(rs.getString("product_summary"));
                    product.setSellerId(rs.getInt("seller_id"));
                    product.setProductDetail(rs.getString("product_details"));
                }
                Products.add(product);
            }
        }
        return Products;
    }

    @Override
    // 依据商品ID得到商品的具体信息
    public Product getProductInfo(int productId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        Product product = new Product();
        String getProductInfoByProductIdSql = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID=?";
        PreparedStatement stmt = con.prepareStatement(getProductInfoByProductIdSql);
        stmt.setInt(1, productId);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            product.setProductName(rs.getString("product_name"));
            product.setProductId(rs.getInt("product_id"));
            product.setProductPic(rs.getString("product_pic"));
            product.setProductPrice(rs.getFloat("product_price"));
            product.setProductPriceOrigin(rs.getFloat("product_price_origin"));
            product.setProductArea(rs.getInt("product_area"));
            product.setProductType(rs.getInt("product_type"));
            product.setProductInventory(rs.getInt("product_inventory"));
            product.setProductSellAmount(rs.getInt("product_sell_amount"));
            product.setProductDeadLine(rs.getDate("product_deadline"));
            product.setProductSummary(rs.getString("product_summary"));
            product.setSellerId(rs.getInt("seller_id"));
            product.setProductDetail(rs.getString("product_details"));
        }
        return product;
    }

    @Override
    // 通过商品ID添加到订单表
    public boolean addProductToOrder(int userId, int productId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String addProductToOrderSql = "INSERT INTO ORDERS(USER_ID, PRODUCT_ID) VALUES (?,?)";
        PreparedStatement stmt = con.prepareStatement(addProductToOrderSql);
        stmt.setInt(1, userId);
        stmt.setInt(2, productId);

        int m = stmt.executeUpdate();

        if(m>0){
            boolean isSuccess = changeMoneyBuyProduct(userId, productId);
            if (isSuccess){
                return true;
            }
        }
        return false;
    }

    @Override
    // 通过用户ID得到其所有的订单的信息
    public List<Product> getAllProductUserBuy(int userId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();


        List<Product> products = new ArrayList<>();

        List<String> productIds = getAllProductIdUserBuy(userId);

        String getProductUserBuySql = "SELECT PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_PIC, PRODUCT_SUMMARY FROM PRODUCTS WHERE PRODUCT_ID=?";

        for (String productId: productIds){
            PreparedStatement stmt = con.prepareStatement(getProductUserBuySql);
            stmt.setInt(1, Integer.valueOf(productId));
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            while (rs.next()){
                Product product = new Product();
                for (int i=0; i<rsMeta.getColumnCount(); i++){
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getFloat("product_price"));
                    product.setProductPic(rs.getString("product_pic"));
                    product.setProductSummary(rs.getString("product_summary"));
                }
                products.add(product);
            }
        }

        return products;
    }

    @Override
    // 通过用户ID得到其所有的订单ID中的商品ID
    public List<String> getAllProductIdUserBuy(int userId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String> productIds = new ArrayList<>();
        String getAllProductIdUserBuySql = "SELECT PRODUCT_ID FROM ORDERS WHERE USER_ID=?";
        PreparedStatement stmt = con.prepareStatement(getAllProductIdUserBuySql);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            int productId = rs.getInt("product_id");
            productIds.add(String.valueOf(productId));
        }
        return productIds;
    }

    @Override
    // 通过分类ID和城市ID得到所有的团购信息
    public List<Product> getAllProductByTypeAndCity(int cityId, int foodTypeId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<Product> Products = new ArrayList<>();  // 产品类的集合
        List<String> districtIdss = getAllDistrictByCityId(cityId);  // 地区ID
        for (String districtId : districtIdss){
            String getProductByCityId = "SELECT * FROM PRODUCTS WHERE PRODUCT_AREA=? AND PRODUCT_TYPE=? ";
            PreparedStatement stmt = con.prepareStatement(getProductByCityId);
            stmt.setInt(1, Integer.valueOf(districtId));
            stmt.setFloat(2, foodTypeId);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            while (rs.next()){
                Product product = new Product();   // 产品类
                for (int i=0; i<rsMeta.getColumnCount(); i++){
                    product.setProductId(rs.getInt("product_id"));
                    product.setProductPic(rs.getString("product_pic"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getFloat("product_price"));
                    product.setProductPriceOrigin(rs.getFloat("product_price_origin"));
                    product.setProductArea(rs.getInt("product_area"));
                    product.setProductType(rs.getInt("product_type"));
                    product.setProductInventory(rs.getInt("product_inventory"));
                    product.setProductSellAmount(rs.getInt("product_sell_amount"));
                    product.setProductDeadLine(rs.getDate("product_deadline"));
                    product.setProductSummary(rs.getString("product_summary"));
                    product.setSellerId(rs.getInt("seller_id"));
                    product.setProductDetail(rs.getString("product_details"));
                }
                Products.add(product);
            }
        }
        return Products;
    }

    @Override
    // 购买商品，余额减少， 并给卖家增加钱数
    public boolean changeMoneyBuyProduct(int userId, int productId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        // 得到商品价格 和 卖家的id
        float productPrice = 0;
        int sellerId = 0;
        String getProductMessageSql = "SELECT PRODUCT_PRICE, SELLER_ID FROM PRODUCTS WHERE PRODUCT_ID=?";
        PreparedStatement stmt = con.prepareStatement(getProductMessageSql);
        stmt.setInt(1, productId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            productPrice = rs.getFloat("product_price");
            sellerId = rs.getInt("seller_id");
        }

        float userMoney = getMoneyByUserId(userId);
        float sellerMoney = getMoneyByUserId(sellerId);

        float newUserMoney = userMoney - productPrice;
        float newSellerMoney = sellerMoney + productPrice;

        boolean isReduce = updateMoneyByUserId(userId, newUserMoney);
        boolean isAdd = updateMoneyByUserId(sellerId, newSellerMoney);

        List<String> amount = getInventoryAndSoldAmount(productId);
        System.out.println(amount);
        int newInventory = Integer.valueOf(amount.get(0)) - 1;
        int newSoldAmount = Integer.valueOf(amount.get(1)) + 1;

        boolean isUpdateAmount = updateInventoryAndSoldAmoubt(productId, newInventory, newSoldAmount);

        if (isReduce){
            if (isAdd){
                if (isUpdateAmount)
                    return true;
            }
        }
        return false;
    }

    @Override
    public float getMoneyByUserId(int userId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        float money=0;
        String getMoneyByUserIdSql = "SELECT USER_MONEY FROM USERS WHERE USER_ID=?";
        PreparedStatement stmt = con.prepareStatement(getMoneyByUserIdSql);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            money = rs.getFloat("user_money");
        }

        return money;
    }

    @Override
    public boolean updateMoneyByUserId(int userId, float money) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String updateMoneySql = "UPDATE USERS SET USER_MONEY=? WHERE USER_ID=?";
        PreparedStatement stmt = con.prepareStatement(updateMoneySql);
        stmt.setFloat(1, money);
        stmt.setInt(2, userId);

        int m = stmt.executeUpdate();
        return m>0;
    }

    @Override
    public List<String> getInventoryAndSoldAmount(int productId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String> numbers = new ArrayList<>();
        String getProductAmountSql = "SELECT PRODUCT_INVENTORY, PRODUCT_SELL_AMOUNT FROM PRODUCTS WHERE PRODUCT_ID=?";
        PreparedStatement stmt = con.prepareStatement(getProductAmountSql);
        stmt.setInt(1, productId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            String inventory = String.valueOf(rs.getInt("product_inventory"));
            String soldAmount = String.valueOf(rs.getInt("product_sell_amount"));
            numbers.add(inventory);
            numbers.add(soldAmount);
        }
        return numbers;
    }

    @Override
    public boolean updateInventoryAndSoldAmoubt(int productId, int ven, int soldAmount) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String updateAmountSql = "UPDATE PRODUCTS SET PRODUCT_INVENTORY=?,PRODUCT_SELL_AMOUNT=? WHERE PRODUCT_ID=?";
        PreparedStatement stmt = con.prepareStatement(updateAmountSql);
        stmt.setInt(1, ven);
        stmt.setInt(2, soldAmount);
        stmt.setInt(3, productId);

        int m = stmt.executeUpdate();
        return m>0;
    }


}
