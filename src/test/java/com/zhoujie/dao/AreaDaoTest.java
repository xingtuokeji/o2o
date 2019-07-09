package com.zhoujie.dao;

import com.zhoujie.BaseTest;
import com.zhoujie.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 启动junit，加载spring配置spring-dao.xml对数据库进行操作
 */
public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
//        assertEquals(areaList.size(),3);
        System.out.println(areaList.get(0).toString());
    }

}
