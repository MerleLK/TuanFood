package com.tuan.Action.sellerAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.SellerDAO;
import com.tuan.DB.DAO.UserDAO;
import com.tuan.DB.DAOImpl.SellerDAOImpl;
import com.tuan.DB.DAOImpl.UserDAOImpl;

import java.util.List;

/** 展示所有已经上架的商品
 * Created by Administrator on 2017/6/26.
 */
public class getAllPublishProductAction extends ActionSupport{

    private List<String[]> products;

    public List<String[]> getProducts() {
        return products;
    }

    public void setProducts(List<String[]> products) {
        this.products = products;
    }

    @Override
    public String execute() throws Exception{
        SellerDAO sellerDAO = new SellerDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        String username = ActionContext.getContext().getSession().get("username").toString();
        int sellerId = userDAO.getUserIdByName(username);

        products = sellerDAO.showAllPublishProduct(sellerId);

        return SUCCESS;
    }
}
