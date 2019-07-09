package com.zhoujie.service;

import com.zhoujie.BaseTest;
import com.zhoujie.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList.size()+":"+areaList.get(1).getPriority());
    }

}
