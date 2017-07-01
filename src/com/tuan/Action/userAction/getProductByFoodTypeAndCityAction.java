package com.tuan.Action.userAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.domain.Product;

import java.util.List;

/** 依据分类和 城市ID的到所有商品
 * Created by Administrator on 2017/6/29.
 */
public class getProductByFoodTypeAndCityAction extends ActionSupport{

    private List<String[]> citys;
    private List<Product> products;
    private List<String[]> foodTypes;
    private int cityId;
    private int foodTypeId;

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

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    //依据分类ID和城市ID得到所有美食
    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();

        citys = adminDAO.getAllCitys();
        foodTypes = adminDAO.getAllFoodType();
        products = customerDAO.getAllProductByTypeAndCity(cityId, foodTypeId);

        return SUCCESS;
    }

}
