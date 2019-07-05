package com.shpos.controller.shopAdmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shpos.dao.dto.ShopExecution;
import com.shpos.entity.Area;
import com.shpos.entity.Shop;
import com.shpos.entity.ShopCategory;
import com.shpos.entity.UserInfo;
import com.shpos.enume.ShopStateEnum;
import com.shpos.service.AreaService;
import com.shpos.service.ShopSeCategoryService;
import com.shpos.service.ShopService;
import com.shpos.utils.CodeUtil;
import com.shpos.utils.HttpServletRequestUtil;
import com.shpos.utils.ImageUtil;
import com.shpos.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by likaisong on 2019/4/23.
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopSeCategoryService shopSeCategoryService;

    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/getshopinitinfo")
    @ResponseBody
    public Map<String, Object> getShopinitinfo() {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<ShopCategory> shopCategoryList = shopSeCategoryService.getShopCategoryList(new ShopCategory());
            List<Area> areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList", shopCategoryList);
            modelMap.put("areaList", areaList);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());

        }
        return modelMap;
    }

    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        if (!CodeUtil.checkVerifyCode(request)){
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码错误");
            return modelMap;
        }
        //接收并转化参数
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = objectMapper.readValue(shopStr, Shop.class);
        } catch (IOException e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        //处理图片文件信息
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (resolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        //注册店铺
        if (shop != null && shopImg != null) {
            UserInfo owner = new UserInfo();
            //Session TODO
            owner.setUserId(1);
            shop.setOwner(owner);
            ShopExecution execution = null;
            try {
                execution = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
                if (execution.getState() == ShopStateEnum.CHECK.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", execution.getStateInfo());
                }
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "店铺信息不能为空");
            return modelMap;
        }
        //返回结果
        return modelMap;
    }
}
