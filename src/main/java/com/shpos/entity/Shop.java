package com.shpos.entity;

import java.util.Date;

/**
 * Created by likaisong on 2019/4/6.
 */
public class Shop {
    private Integer shopId;
    private String shopName;
    private String shopDesc;
    private Integer priority;
    private String shopAdress;
    private String phone;
    private String shopImg;
    private String advice;
    private Area area;
    private UserInfo owner;
    // -1 不可用 0 审核中 1可用
    private Integer enableStatus;
    private ShopCategory shopCategory;
    private Date createTime;
    private Date modifyTime;

    public Integer getShopId() {
        return shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getShopAdress() {
        return shopAdress;
    }

    public String getPhone() {
        return phone;
    }

    public String getShopImg() {
        return shopImg;
    }

    public String getAdvice() {
        return advice;
    }

    public Area getArea() {
        return area;
    }

    public UserInfo getOwner() {
        return owner;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setShopAdress(String shopAdress) {
        this.shopAdress = shopAdress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setOwner(UserInfo owner) {
        this.owner = owner;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
