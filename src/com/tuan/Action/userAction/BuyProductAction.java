package com.tuan.Action.userAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.DAOImpl.UserDAOImpl;

/** 购买商品 添加到订单表中
 * Created by Administrator on 2017/6/29.
 */
public class BuyProductAction extends ActionSupport{
    private String username;
    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        int userId = userDAO.getUserIdByName(username);
        CustomerDAO customerDAO = new CustomerDAOImpl();
        boolean isSuccess = customerDAO.addProductToOrder(userId, productId);
        if (isSuccess){
            addActionMessage("购买成功!已转到查看所有记录页面.");
            return SUCCESS;
        }

        addActionError("购买失败!");
        return "fail";
    }
}
