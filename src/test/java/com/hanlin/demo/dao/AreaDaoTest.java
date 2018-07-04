package com.hanlin.demo.dao;

import com.hanlin.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areas = areaDao.queryArea();
        assertEquals(0, areas.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("冯倩怡", area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int i = areaDao.insertArea(area);
    }

    @Test
    public void updateArea() {
        Area area = areaDao.queryAreaById(2);
        area.setPriority(2);
        int i = areaDao.updateArea(area);
        assertEquals(1, i);
    }

    @Test
    public void deleteArea() {
        int i = areaDao.deleteArea(1);
        assertEquals(1,i);
    }
}