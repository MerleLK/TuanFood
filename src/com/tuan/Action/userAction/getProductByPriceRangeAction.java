package com.tuan.Action.userAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.domain.Product;

import java.util.List;

/** 通过价格区间得到商品
 * Created by Administrator on 2017/6/29.
 */
public class getProductByPriceRangeAction extends ActionSupport{

    private List<String[]> citys;
    private List<Product> products;
    private List<String[]> foodTypes;
    private int cityId;
    private float lowPrice;
    private float highPrice;

    public List<String[]> getCitys() {
        return citys;
    }

    public void setCitys(List<String[]> citys) {
        this.citys = citys;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<String[]> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<String[]> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
    }

    public float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(float highPrice) {
        this.highPrice = highPrice;
    }

    // 依据价格区间得到该城市下所有美食
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();

        citys = adminDAO.getAllCitys();
        foodTypes = adminDAO.getAllFoodType();
        products = customerDAO.getAllProductByCityIdAndPrice(cityId, lowPrice, highPrice);

        return SUCCESS;
    }
}
