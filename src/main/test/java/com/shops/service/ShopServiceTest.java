package com.shops.service;

import com.shops.BaseTest;
import com.shpos.dao.dto.ShopExecution;
import com.shpos.entity.Area;
import com.shpos.entity.Shop;
import com.shpos.entity.ShopCategory;
import com.shpos.entity.UserInfo;
import com.shpos.enume.ShopStateEnum;
import com.shpos.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by likaisong on 2019/4/23.
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {
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
        shop.setAdvice("addShop建议");
        shop.setEnableStatus(1);
        shop.setCreateTime(new Date());
        shop.setPhone("addShop112233");
        shop.setPriority(1);
        shop.setShopAdress("addShop测试地址");
        shop.setShopDesc("addShop测试描述");
        shop.setShopName("addShop测试店名6");
        File shopImg = new File("/Users/likaisong/Downloads/好鸭.gif");
        InputStream shopImgInputStream = new FileInputStream(shopImg);
        ShopExecution execution = shopService.addShop(shop, shopImgInputStream, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), execution.getState());
    }
}
