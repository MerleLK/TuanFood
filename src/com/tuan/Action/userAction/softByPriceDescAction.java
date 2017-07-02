package com.tuan.Action.userAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.domain.Product;

import java.util.Comparator;
import java.util.List;

/** 按照价格降序排列
 * Created by Administrator on 2017/6/29.
 */
public class softByPriceDescAction extends ActionSupport{

    private List<String[]> citys;
    private List<Product> products;
    private List<String[]> foodTypes;
    private int cityId;

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

    // 依据价格降序排列
    public String execute() throws Exception{
        AdminDAO adminDAO = new AdminDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();

        citys = adminDAO.getAllCitys();
        foodTypes = adminDAO.getAllFoodType();
        products = customerDAO.getSoftProductByCityId(cityId);

        // todo 可能会出现bug 需要再考虑
//        Comparator<Product> comparator = new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return String.valueOf(o2.getProductPrice()).compareTo(String.valueOf(o1.getProductPrice()));
//            }
//        };
//        products.sort(comparator);
        // use lambda
        products.sort((Product o1, Product o2) ->
                String.valueOf(o2.getProductPrice()).compareTo(String.valueOf(o1.getProductPrice())));
        return SUCCESS;
    }
}
