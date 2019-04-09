package com.shops.dao;

import com.shops.BaseTest;
import com.shpos.dao.ShopDao;
import com.shpos.entity.Area;
import com.shpos.entity.Shop;
import com.shpos.entity.ShopCategory;
import com.shpos.entity.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by likaisong on 2019/4/9.
 */
public class ShopDaoTest extends BaseTest{
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        Area area = new Area();
        area.setAreaId(1);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1l);

        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setOwner(userInfo);
        shop.setAdvice("建议");
        shop.setEnableStatus(1);
        shop.setCreateTime(new Date());
        shop.setPhone("112233");
        shop.setPriority(1);
        shop.setShopAdress("测试地址");
        shop.setShopDesc("测试描述");
        shop.setShopName("测试店名2");
        shop.setShopImg("test img");

        int result = shopDao.insertShop(shop);
        assertEquals(1, result);
    }
}
