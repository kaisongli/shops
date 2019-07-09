package com.shops.dao;

import com.shops.BaseTest;
import com.shpos.dao.AreaDao;
import com.shpos.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by likaisong on 2019/4/7.
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testAreaQuery() {
        List<Area> areas = areaDao.queryArea();
        assertEquals("地区4", areas.get(0).getAreaName());
        assertEquals(4, areas.size());
    }
}
