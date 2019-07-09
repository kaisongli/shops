package com.shops.dao;

import com.shops.BaseTest;
import com.shpos.dao.ShopCategoryDao;
import com.shpos.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by likaisong on 2019-06-28.
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory() {
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(4, shopCategories.size());
    }
}
