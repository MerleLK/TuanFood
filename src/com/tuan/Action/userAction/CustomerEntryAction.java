package com.tuan.Action.userAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.domain.Product;

import java.util.List;
import java.util.Map;

/** 用户进入首页的Action
 * Created by Administrator on 2017/6/29.
 */
public class CustomerEntryAction  extends ActionSupport{

    private List<String[]> citys;
    private List<Product> products;
    private List<String[]> foodTypes;
    private int cityId;
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

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

    @Override
    // 进入首页默认执行方法
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();

        citys = adminDAO.getAllCitys();
        foodTypes = adminDAO.getAllFoodType();
        products = customerDAO.getAllProductByCityId(cityId);
        cityName = customerDAO.getCityNameByCityId(cityId);
        System.out.println(citys);
        System.out.println(foodTypes);
        System.out.println(products);
        System.out.println(cityName);
        System.out.println(cityId);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("newCityName", cityName);
        session.put("newCityId", cityId);

        return SUCCESS;
    }

}
