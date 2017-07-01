package com.tuan.DB.domain;

/** 订单表的类
 * Created by Administrator on 2017/6/29.
 */
public class Order {

    private int orderId;
    private int userId;
    private int productId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
