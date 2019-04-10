package com.shpos.dao;

import com.shpos.entity.Shop;

/**
 * Created by likaisong on 2019/4/9.
 */
public interface ShopDao {
    /**
     * 新增店铺
     * -1 失败 1 成功
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
