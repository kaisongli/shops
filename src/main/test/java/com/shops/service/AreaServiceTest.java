package com.shops.service;

import com.shops.BaseTest;
import com.shpos.entity.Area;
import com.shpos.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by likaisong on 2019/4/7.
 */
public class AreaServiceTest extends BaseTest{
    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areas = areaService.getAreaList();
        assertEquals(2, areas.size());
    }
}
