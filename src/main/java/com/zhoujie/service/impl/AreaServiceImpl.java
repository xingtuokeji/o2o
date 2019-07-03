package com.zhoujie.service.impl;

import com.zhoujie.dao.AreaDao;
import com.zhoujie.entity.Area;
import com.zhoujie.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
