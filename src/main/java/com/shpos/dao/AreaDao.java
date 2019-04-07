package com.shpos.dao;

import com.shpos.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likaisong on 2019/4/7.
 */
@Repository
public interface AreaDao {
    List<Area> queryArea();
}
