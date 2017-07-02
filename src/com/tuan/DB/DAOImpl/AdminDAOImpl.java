package com.tuan.DB.DAOImpl;

import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DBManager.DatabaseConnection;
import com.tuan.DB.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * admin 数据库操作实现
 * Created by Administrator on 2017/6/25.
 */
public class AdminDAOImpl implements AdminDAO {

    @Override
    public boolean checkCity(String cityName) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String checkCitySql = "SELECT * FROM CITYS WHERE CITY_NAME=?";
        PreparedStatement stmt = con.prepareStatement(checkCitySql);
        stmt.setString(1, cityName);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    @Override
    // 添加城市
    public boolean addCity(String cityName) throws Exception {

        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String addCitySql = "INSERT  INTO CITYS(CITY_NAME) VALUES (?)";
        PreparedStatement stmt = con.prepareStatement(addCitySql);
        stmt.setString(1, cityName);
        int m = stmt.executeUpdate();

        return m > 0;
    }

    @Override
    public List<String[]> getAllCitys() throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String[]> citys = new ArrayList<>();
        String showAllCitySql = "SELECT * FROM CITYS";
        PreparedStatement stmt = con.prepareStatement(showAllCitySql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String[] row = new String[2];
            row[0] = String.valueOf(rs.getInt("city_id"));
            row[1] = rs.getString("city_name");
            citys.add(row);
        }
        return citys;
    }

    @Override
    public City getCityByCityId(int cityId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        City city = new City();
        String getCitySql = "SELECT * FROM CITYS WHERE CITY_ID=?";
        PreparedStatement stmt = con.prepareStatement(getCitySql);
        stmt.setInt(1, cityId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            city.setCityId(rs.getInt("city_id"));
            city.setCityName(rs.getString("city_name"));
        }
        return city;
    }

    @Override
    public boolean editCity(int cityId, String cityName) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String editCitySql = "UPDATE CITYS SET CITY_NAME=? WHERE CITY_ID=?";
        PreparedStatement stmt = con.prepareStatement(editCitySql);
        stmt.setString(1, cityName);
        stmt.setInt(2, cityId);

        int m = stmt.executeUpdate();
        return m>0;
    }

    @Override
    public boolean checkDistrict(int cityId, String districtName) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String checkDistrictSql = "SELECT * FROM DISTRICTS WHERE CITY_ID=? AND DISTRICT_NAME=?";
        PreparedStatement stmt = con.prepareStatement(checkDistrictSql);
        stmt.setInt(1, cityId);
        stmt.setString(2, districtName);

        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    @Override
    public boolean addDistrict(int cityId, String districtName) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String addDistrictSql = "INSERT INTO DISTRICTS (DISTRICT_NAME, CITY_ID) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(addDistrictSql);
        stmt.setString(1, districtName);
        stmt.setInt(2, cityId);
        int m = stmt.executeUpdate();

        return m > 0;
    }

    @Override
    public List<String[]> getAllDistricts() throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String[]> districts = new ArrayList<>();
        String showAllDistrictSql = "SELECT DISTRICT_ID, DISTRICT_NAME, CITYS.CITY_NAME FROM DISTRICTS, CITYS " +
                "WHERE DISTRICTS.CITY_ID=CITYS.CITY_ID ORDER BY DISTRICTS.CITY_ID";
        PreparedStatement stmt = con.prepareStatement(showAllDistrictSql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String[] row = new String[3];
            row[0] = String.valueOf(rs.getInt("district_id"));
            row[1] = rs.getString("district_name");
            row[2] = rs.getString("CITY_NAME");
            districts.add(row);
        }
        return districts;


    }

    @Override
    public District getDistrictByDistrictId(int districtId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        District district = new District();
        String getDistrictSql = "SELECT DISTRICT_ID, DISTRICT_NAME, CITY_NAME FROM DISTRICTS, CITYS WHERE DISTRICT_ID=? AND CITYS.CITY_ID=DISTRICTS.CITY_ID";
        PreparedStatement stmt = con.prepareStatement(getDistrictSql);
        stmt.setInt(1, districtId);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            district.setDistrictId(rs.getInt("district_id"));
            district.setDistrictName(rs.getString("district_name"));
            district.setCityName(rs.getString("CITY_NAME"));
        }
        return district;
    }

    @Override
    public boolean editDistrict(int districtId, String districtName, int cityId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String editDistrictSql = "UPDATE DISTRICTS SET DISTRICT_NAME=?, CITY_ID=? WHERE DISTRICT_ID=?";
        PreparedStatement stmt = con.prepareStatement(editDistrictSql);
        stmt.setString(1, districtName);
        stmt.setInt(2, cityId);
        stmt.setInt(3, districtId);

        int m = stmt.executeUpdate();
        return m>0;
    }

    @Override
    // 得到所有城市信息（id-name）
    public HashMap<String, String> getAllCityId() throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        HashMap<String, String> citys = new HashMap<>();
        String getAllCityIdSql = "SELECT CITY_ID, CITY_NAME FROM CITYS";
        PreparedStatement stmt = con.prepareStatement(getAllCityIdSql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String cityId = String.valueOf(rs.getInt("city_id"));
            String cityName = rs.getString("city_name");
            citys.put(cityId, cityName);
        }
        return citys;
    }

    @Override
    public boolean checkFoodType(String foodType) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String checkFoodTypeSql = "SELECT * FROM FOODTYPES WHERE FOODTYPE_NAME=?";
        PreparedStatement stmt = con.prepareStatement(checkFoodTypeSql);
        stmt.setString(1, foodType);
        ResultSet rs = stmt.executeQuery();

        return rs.next();
    }

    @Override
    public boolean addFoodType(String foodType) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String addFoodTypeSql = "INSERT INTO FOODTYPES (FOODTYPE_NAME) VALUES (?)";
        PreparedStatement stmt = con.prepareStatement(addFoodTypeSql);
        stmt.setString(1, foodType);

        int m = stmt.executeUpdate();
        return m > 0;
    }

    @Override
    public boolean editFoodType(int foodTypeId, String foodTypeName) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String editFoodTypeSql = "UPDATE FOODTYPES SET FOODTYPE_NAME=? WHERE FOODTYPE_ID=?";
        PreparedStatement stmt = con.prepareStatement(editFoodTypeSql);
        stmt.setString(1, foodTypeName);
        stmt.setInt(2, foodTypeId);

        int m = stmt.executeUpdate();
        return m > 0;
    }

    @Override
    public FoodType getFoodTypeById(int foodTypeId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        FoodType foodType = new FoodType();
        String getFoodTypeSql = "SELECT * FROM FOODTYPES WHERE FOODTYPE_ID=?";
        PreparedStatement stmt = con.prepareStatement(getFoodTypeSql);
        stmt.setInt(1, foodTypeId);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            foodType.setFoodTypeId(rs.getInt("foodtype_id"));
            foodType.setFoodTypeName(rs.getString("foodtype_name"));
        }
        return foodType;
    }

    @Override
    public List<String[]> getAllFoodType() throws Exception {

        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String[]> foodTypes = new ArrayList<>();
        String getAllFoodType = "SELECT * FROM FOODTYPES";
        PreparedStatement stmt = con.prepareStatement(getAllFoodType);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String[] row = new String[2];
            row[0] = String.valueOf(rs.getInt("foodtype_id"));
            row[1] = rs.getString("foodtype_name");
            foodTypes.add(row);
        }
        return foodTypes;
    }

    @Override
    // 列出需要审核的团购信息主要信息  todo
    public List<String[]> getAllReviewWithoutCheck() throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String[]> reviews = new ArrayList<>();
        String getAllReviewWithoutCheckSql = "SELECT * FROM REVIEWS WHERE REVIEW_STATUS=0";
        PreparedStatement stmt = con.prepareStatement(getAllReviewWithoutCheckSql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String[] row = new String[4];
            row[0] = String.valueOf(rs.getInt("review_id"));
            row[1] = rs.getString("product_name");
            row[2] = rs.getString("product_pic");
            row[3] = rs.getString("product_summary");
            reviews.add(row);
        }
        return reviews;
    }

    @Override
    public Review getReviewInfo(int reviewId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        Review review = new Review();
        String getReviewInfoSql = "SELECT * FROM REVIEWS WHERE REVIEW_ID=?";
        PreparedStatement stmt = con.prepareStatement(getReviewInfoSql);
        stmt.setInt(1, reviewId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            review.setSellerId(reviewId);
            review.setResult(rs.getString("result"));
            review.setReviewStatus(rs.getInt("review_status"));
            review.setProductName(rs.getString("product_name"));
            review.setProductPic(rs.getString("product_pic"));
            review.setProductPrice(rs.getFloat("product_price"));
            review.setProductPriceOrigin(rs.getFloat("product_price_origin"));
            review.setProductArea(rs.getInt("product_area"));
            review.setProductType(rs.getInt("product_type"));
            review.setProductInventory(rs.getInt("product_inventory"));
            review.setProductSellAmount(rs.getInt("product_sell_amount"));
            review.setProductDeadLine(rs.getDate("product_deadline"));
            review.setProductSummary(rs.getString("product_summary"));
            review.setProductDetail(rs.getString("product_details"));
            review.setSellerId(rs.getInt("seller_id"));
        }
        return review;
    }

    @Override
    public boolean addProduct(Review review) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String addProductSql = "INSERT INTO PRODUCTS(PRODUCT_NAME, PRODUCT_PIC, PRODUCT_PRICE, PRODUCT_PRICE_ORIGIN," +
                "PRODUCT_AREA, PRODUCT_TYPE, PRODUCT_INVENTORY, PRODUCT_SELL_AMOUNT, PRODUCT_DEADLINE, PRODUCT_SUMMARY, " +
                "PRODUCT_DETAILS, SELLER_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement stmt = con.prepareStatement(addProductSql);
        stmt.setString(1, review.getProductName());
        stmt.setString(2, review.getProductPic());
        stmt.setFloat(3, review.getProductPrice());
        stmt.setFloat(4, review.getProductPriceOrigin());
        stmt.setInt(5, review.getProductArea());
        stmt.setInt(6, review.getProductType());
        stmt.setInt(7, review.getProductInventory());
        stmt.setInt(8, review.getProductSellAmount());
        java.sql.Date date = new java.sql.Date(review.getProductDeadLine().getTime());
        stmt.setDate(9, date);
        stmt.setString(10, review.getProductSummary());
        stmt.setString(11, review.getProductDetail());
        stmt.setInt(12, review.getSellerId());

        int m = stmt.executeUpdate();

        return m > 0;
    }

    @Override
    public boolean changeReviewStatus(int reviewId, int reviewStatus) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String changeReviewStatusSql = "UPDATE REVIEWS SET REVIEW_STATUS=? WHERE REVIEW_ID=?";
        PreparedStatement stmt = con.prepareStatement(changeReviewStatusSql);
        stmt.setInt(1, reviewStatus);
        stmt.setInt(2, reviewId);

        int m = stmt.executeUpdate();
        return m > 0;
    }

    @Override
    public List<Product> getAllProduct() throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();


        List<Product> Products = new ArrayList<>();  // 产品类的集合

        String getProductByCityId = "SELECT * FROM PRODUCTS";
        PreparedStatement stmt = con.prepareStatement(getProductByCityId);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsMeta = rs.getMetaData();
        while (rs.next()) {
            Product product = new Product();   // 产品类
            for (int i = 0; i < rsMeta.getColumnCount(); i++) {
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPic(rs.getString("product_pic"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductPriceOrigin(rs.getFloat("product_price_origin"));
                product.setProductType(rs.getInt("product_type"));
                product.setProductArea(rs.getInt("product_area"));
                product.setProductInventory(rs.getInt("product_inventory"));
                product.setProductSellAmount(rs.getInt("product_sell_amount"));
                product.setProductDeadLine(rs.getDate("product_deadline"));
                product.setProductSummary(rs.getString("product_summary"));
                product.setSellerId(rs.getInt("seller_id"));
                product.setProductDetail(rs.getString("product_details"));
            }
            Products.add(product);
        }
        return Products;
    }
}
