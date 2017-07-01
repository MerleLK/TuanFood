package com.tuan.test;

import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.domain.Product;

import java.util.ArrayList;
import java.util.List;

/** 测试用户数据库操作
 * Created by Administrator on 2017/6/29.
 */
public class TestCustomDAO {

    public static void main(String[] args) throws Exception{

        int cityId = 2;
        float lowPrice = 10;
        float highPrice = 133;
        List<Product> products = new ArrayList<>();
        List<String> districts = new ArrayList<>();
        Product product = new Product();

        CustomerDAO customerDAO = new CustomerDAOImpl();

        districts = customerDAO.getAllDistrictByCityId(cityId);
//        products = customerDAO.getAllProductByCityId(cityId);
//        products = customerDAO.getSoftProductByCityId(cityId);
//        products = customerDAO.getAllProductByCityIdAndPrice(cityId, lowPrice, highPrice);
//        product = customerDAO.getProductInfo(0);
        products = customerDAO.getAllProductUserBuy(4);
        System.out.println(districts);
        System.out.println(products);


    }

}
