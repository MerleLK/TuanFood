package com.tuan.Action.userAction;

import com.opensymphony.xwork2.ActionSupport;
import com.tuan.DB.DAO.CustomerDAO;
import com.tuan.DB.DAOImpl.CustomerDAOImpl;
import com.tuan.DB.domain.Product;

/** 通过ID得到商品的详细信息
 * Created by Administrator on 2017/6/29.
 */
public class getProductInfoAction extends ActionSupport {

    private Product product;
    private int productId;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String execute() throws Exception{

        CustomerDAO customerDAO = new CustomerDAOImpl();
        product = customerDAO.getProductInfo(productId);
        return SUCCESS;
    }
}
