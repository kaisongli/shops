package com.shpos.service;

import com.shpos.dao.dto.ShopExecution;
import com.shpos.entity.Shop;

import java.io.InputStream;

/**
 * Created by likaisong on 2019/4/23.
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) ;
}
