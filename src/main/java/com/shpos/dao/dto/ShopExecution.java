package com.shpos.dao.dto;

import com.shpos.entity.Shop;
import com.shpos.enume.ShopStateEnum;

import java.util.List;

/**
 * Created by likaisong on 2019/4/12.
 */
public class ShopExecution {
    //结果状态
    private int state;

    //状态信息
    private String stateInfo;

    //结果数量
    private int count;

    //增删改的店铺
    private Shop shop;

    //查询多店铺
    private List<Shop> shopList;

    public ShopExecution() {
    }

    /**
     * 店铺操作失败构造器
     * @param stateEnum
     */
    public ShopExecution(ShopStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 增删改成功构造器
     * @param stateEnum
     */
    public ShopExecution(ShopStateEnum stateEnum, Shop shop){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     * 查询成功构造器
     * @param stateEnum
     */
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public int getCount() {
        return count;
    }

    public Shop getShop() {
        return shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
