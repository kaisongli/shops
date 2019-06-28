package com.shpos.service;

import com.shpos.entity.Area;
import com.shpos.entity.ShopCategory;

import java.util.List;

/**
 * Created by likaisong on 2019/4/7.
 */
public interface ShopSeCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategory);
}
