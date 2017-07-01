package com.tuan.Action.userAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.DAOImpl.UserDAOImpl;
import com.tuan.DB.domain.Product;

import java.util.List;

/** 用户订单展示
 * Created by Administrator on 2017/6/29.
 */
public class showAllOrderAction extends ActionSupport{

    private List<Product> products;
    private String username;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() throws Exception{

        UserDAO userDAO = new UserDAOImpl();
        if (username == null){
            username = ActionContext.getContext().getSession().get("username").toString();
        }
        int userId = userDAO.getUserIdByName(username);
        CustomerDAO customerDAO = new CustomerDAOImpl();
        products = customerDAO.getAllProductUserBuy(userId);
        return SUCCESS;
    }
}
