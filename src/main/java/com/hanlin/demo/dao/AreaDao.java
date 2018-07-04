package com.hanlin.demo.dao;

import com.hanlin.demo.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaDao {
    List<Area> queryArea();

    Area queryAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int areaId);

}
