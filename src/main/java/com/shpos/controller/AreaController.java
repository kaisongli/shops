package com.shpos.controller;

import com.shpos.entity.Area;
import com.shpos.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by likaisong on 2019/4/7.
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listArea() {
        Map<String, Object> areaMap = new HashMap<>();
        List<Area> areas = areaService.getAreaList();
        try {
            areaMap.put("rows", areas);
            areaMap.put("total", areas.size());
        } catch (Exception e) {
            areaMap.put("success", false);
            areaMap.put("message", e.getMessage().toString());
        }
        return areaMap;
    }
}
