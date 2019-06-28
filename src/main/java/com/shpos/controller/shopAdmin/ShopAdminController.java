package com.shpos.controller.shopAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by likaisong on 2019/5/27.
 */
@Controller
@RequestMapping(value = "/shopadmin")
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
    }
}
