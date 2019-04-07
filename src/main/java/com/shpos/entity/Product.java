package com.shpos.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by likaisong on 2019/4/7.
 */
public class Product {
    private Integer productId;
    private String productName;
    private String productDesc;
    private Integer priority;
    private String productAdress;
    private String imgAdress;
    private List<ProdcutImg> prodcutImgs;
    private String normalPrice;
    private String discountPrice;
    //0 下架 1可用
    private Integer enableStatus;
    private ShopCategory shopCategory;
    private Shop shop;
    private Date createTime;
    private Date modifyTime;

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getProductAdress() {
        return productAdress;
    }

    public String getImgAdress() {
        return imgAdress;
    }

    public List<ProdcutImg> getProdcutImgs() {
        return prodcutImgs;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public Shop getShop() {
        return shop;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setProductAdress(String productAdress) {
        this.productAdress = productAdress;
    }

    public void setImgAdress(String imgAdress) {
        this.imgAdress = imgAdress;
    }

    public void setProdcutImgs(List<ProdcutImg> prodcutImgs) {
        this.prodcutImgs = prodcutImgs;
    }

    public void setNormalPrice(String normalPrice) {
        this.normalPrice = normalPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
