package com.tuan.DB.DAOImpl;

import com.tuan.DB.DAO.SellerDAO;
import com.tuan.DB.DBManager.DatabaseConnection;
import com.tuan.DB.domain.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/** 店铺管理员的数据库操作实现
 * Created by Administrator on 2017/6/25.
 */
public class SellerDAOImpl implements SellerDAO{
    @Override
    public HashMap<String, String> getAllFoodType() throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        HashMap<String, String> foodTypes = new HashMap<>();
        String getAllFoodTypeSql = "SELECT * FROM FOODTYPES";
        PreparedStatement stmt = con.prepareStatement(getAllFoodTypeSql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            String foodTypeId = String.valueOf(rs.getInt("foodtype_id"));
            String foodTypeName = rs.getString("foodtype_name");
            foodTypes.put(foodTypeId, foodTypeName);
        }
        return foodTypes;
    }

    @Override
    public HashMap<String, String> getAllArea() throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        HashMap<String, String> areas = new HashMap<>();
        String getAllAreaSql = "SELECT * FROM DISTRICTS";
        PreparedStatement stmt = con.prepareStatement(getAllAreaSql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            String areaId = String.valueOf(rs.getInt("district_id"));
            String areaName = rs.getString("district_name");
            areas.put(areaId, areaName);
        }
        return areas;
    }

    @Override
    public boolean checkReview(String productName, int productAreaId, int productTypeId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String checkReviewSql = "SELECT * FROM REVIEWS WHERE PRODUCT_NAME=? AND PRODUCT_AREA=? AND PRODUCT_TYPE=?";
        PreparedStatement stmt = con.prepareStatement(checkReviewSql);
        stmt.setString(1, productName);
        stmt.setInt(2, productAreaId);
        stmt.setInt(3, productTypeId);
        ResultSet rs = stmt.executeQuery();

        return rs.next();
    }

    @Override
    public boolean checkProduct(String productName, int productAreaId, int productTypeId) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String checkProductSql = "SELECT * FROM PRODUCTS WHERE PRODUCT_NAME=? AND PRODUCT_AREA=? AND PRODUCT_TYPE=?";
        PreparedStatement stmt = con.prepareStatement(checkProductSql);

        stmt.setString(1, productName);
        stmt.setInt(2, productAreaId);
        stmt.setInt(3, productTypeId);
        ResultSet rs = stmt.executeQuery();

        return rs.next();
    }

    @Override
    public boolean addProduct(Review review) throws Exception
    {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        String addProductSql = "INSERT INTO REVIEWS(RESULT, PRODUCT_NAME, PRODUCT_PIC, PRODUCT_PRICE, PRODUCT_PRICE_ORIGIN, " +
                "PRODUCT_AREA, PRODUCT_TYPE, PRODUCT_INVENTORY, PRODUCT_DEADLINE, PRODUCT_SUMMARY, PRODUCT_DETAILS, SELLER_ID) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(addProductSql);
        stmt.setString(1, review.getResult());
        stmt.setString(2, review.getProductName());
        stmt.setString(3, review.getProductPic());
        stmt.setFloat(4, review.getProductPrice());
        stmt.setFloat(5, review.getProductPriceOrigin());
        stmt.setInt(6, review.getProductArea());
        stmt.setInt(7, review.getProductType());
        stmt.setInt(8, review.getProductInventory());
        java.sql.Date date = new java.sql.Date(review.getProductDeadLine().getTime());
        stmt.setDate(9, date);
        stmt.setString(10, review.getProductSummary());
        stmt.setString(11, review.getProductDetail());
        stmt.setInt(12, review.getSellerId());

        int m = stmt.executeUpdate();
        return m>0;
    }

    @Override
    public List<String[]> showAllPublishProduct(int sellerID) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String[]> products = new ArrayList<>();
        String showAllPublishProductSql = "SELECT * FROM PRODUCTS WHERE SELLER_ID=?";
        PreparedStatement stmt = con.prepareStatement(showAllPublishProductSql);
        stmt.setInt(1, sellerID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            String[] row = new String[12];
            row[0] = String.valueOf(rs.getInt("product_id"));
            row[1] = rs.getString("product_name");
            row[2] = rs.getString("product_pic");
            row[3] = String.valueOf(rs.getFloat("product_price"));
            row[4] = String.valueOf(rs.getFloat("product_price_origin"));
            row[5] = String.valueOf(rs.getInt("product_area"));
            row[6] = String.valueOf(rs.getInt("product_type"));
            row[7] = String.valueOf(rs.getInt("product_inventory"));
            row[8] = String.valueOf(rs.getInt("product_sell_amount"));
            row[9] = String.valueOf(rs.getDate("product_deadline"));
            row[10] = rs.getString("product_summary");
            row[11] = rs.getString("product_details");

            products.add(row);
        }

        return products;
    }

    @Override
    public List<String[]> showAllReviewProduct(int sellerID) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();

        List<String[]> reviews = new ArrayList<>();
        String showAllReviewProductSql = "SELECT * FROM REVIEWS WHERE SELLER_ID=?";
        PreparedStatement stmt = con.prepareStatement(showAllReviewProductSql);
        stmt.setInt(1, sellerID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            String[] row = new String[6];
            row[0] = String.valueOf(rs.getInt("review_id"));
            row[1] = rs.getString("product_name");
            row[2] = rs.getString("product_pic");
            row[3] = rs.getString("product_summary");
            row[4] = rs.getString("result");
            row[5] = String .valueOf(rs.getInt("review_status"));
            reviews.add(row);
        }
        return reviews;
    }
}
