package com.shpos.entity;

import java.util.Date;

/**
 * Created by likaisong on 2019/4/7.
 */
public class ProdcutImg {
    private Long productImgId;
    private String imgAdress;
    private String imgDesc;
    private Integer priority;
    private Date createTime;
    private Long productId;

    public Long getProductImgId() {
        return productImgId;
    }

    public String getImgAdress() {
        return imgAdress;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductImgId(Long productImgId) {
        this.productImgId = productImgId;
    }

    public void setImgAdress(String imgAdress) {
        this.imgAdress = imgAdress;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
