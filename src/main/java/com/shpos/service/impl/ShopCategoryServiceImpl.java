package com.shpos.service.impl;

import com.shpos.dao.ShopCategoryDao;
import com.shpos.entity.ShopCategory;
import com.shpos.service.ShopSeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by likaisong on 2019/4/7.
 */
@Service
public class ShopCategoryServiceImpl implements ShopSeCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
        return shopCategoryDao.queryShopCategory(shopCategory);
    }
}
