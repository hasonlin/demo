package com.hanlin.demo.service.impl;

import com.hanlin.demo.dao.AreaDao;
import com.hanlin.demo.entity.Area;
import com.hanlin.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if(area.getAreaName() !=null&&!"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int i = areaDao.insertArea(area);
                if (i>0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域失败："+e.getMessage());
            } finally {
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean updateArea(Area area) {
        if(area.getAreaId() !=null&&area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try {
                int i = areaDao.updateArea(area);
                if (i>0){
                    return true;
                }else {
                    throw new RuntimeException("修改区域失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改区域失败："+e.getMessage());
            } finally {
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try {
                int i = areaDao.deleteArea(areaId);
                if (i>0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域失败："+e.getMessage());
            } finally {
            }
        }else {
            throw new RuntimeException("区域id不能为空！");
        }
    }
}
