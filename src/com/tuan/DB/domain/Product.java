package com.tuan.DB.domain;

import java.util.Date;

/** 商品的类
 * Created by Administrator on 2017/6/28.
 */
public class Product {

    private int productId;
    private String productName;
    private String productPic;
    private float productPrice;
    private float productPriceOrigin;
    private int productArea;
    private int productType;
    private int productInventory;
    private int productSellAmount;
    private Date productDeadLine;
    private String productSummary;
    private String productDetail;
    private int sellerId;

    public Product(){}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getProductPriceOrigin() {
        return productPriceOrigin;
    }

    public void setProductPriceOrigin(float productPriceOrigin) {
        this.productPriceOrigin = productPriceOrigin;
    }

    public int getProductArea() {
        return productArea;
    }

    public void setProductArea(int productArea) {
        this.productArea = productArea;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }

    public int getProductSellAmount() {
        return productSellAmount;
    }

    public void setProductSellAmount(int productSellAmount) {
        this.productSellAmount = productSellAmount;
    }

    public Date getProductDeadLine() {
        return productDeadLine;
    }

    public void setProductDeadLine(Date productDeadLine) {
        this.productDeadLine = productDeadLine;
    }

    public String getProductSummary() {
        return productSummary;
    }

    public void setProductSummary(String productSummary) {
        this.productSummary = productSummary;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}
