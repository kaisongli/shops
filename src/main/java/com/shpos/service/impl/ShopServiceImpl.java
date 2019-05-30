package com.shpos.service.impl;

import com.shpos.dao.ShopDao;
import com.shpos.dao.dto.ShopExecution;
import com.shpos.entity.Shop;
import com.shpos.enume.ShopStateEnum;
import com.shpos.exception.ShopRuntimeException;
import com.shpos.service.ShopService;
import com.shpos.utils.ImageUtil;
import com.shpos.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by likaisong on 2019/4/23.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        //空值判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //设置店铺初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setModifyTime(new Date());
            //添加店铺信息
            int efectNum = shopDao.insertShop(shop);
            if (efectNum <= 0) {
                throw new ShopRuntimeException("店铺创建失败");
            } else {
                if (shopImgInputStream != null) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopRuntimeException("shopImgInputStream error" + e.getMessage());
                    }
                    //更新图片地址
                    efectNum = shopDao.updateShop(shop);
                    if (efectNum <= 0){
                        throw new ShopRuntimeException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopRuntimeException("addShop error " + e.getMessage());
        }

        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, InputStream inputStream, String fileName) {
        //获取shop图片目录
        String imageDir = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAdrr = ImageUtil.generatorThumbnaila(inputStream, fileName, imageDir);
        shop.setShopImg(shopImgAdrr);
    }
}
