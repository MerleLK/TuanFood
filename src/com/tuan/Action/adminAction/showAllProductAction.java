package com.tuan.Action.adminAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.AdminDAO;
import com.tuan.DB.DAOImpl.AdminDAOImpl;
import com.tuan.DB.domain.Product;

import java.util.List;

/** 管理员展示所有商品
 * Created by Administrator on 2017/7/1.
 */
public class showAllProductAction extends ActionSupport{

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String execute() throws Exception{

        AdminDAO adminDAO = new AdminDAOImpl();
        products = adminDAO.getAllProduct();
        return SUCCESS;
    }

}
