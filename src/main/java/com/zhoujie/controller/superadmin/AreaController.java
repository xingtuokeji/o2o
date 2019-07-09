package com.zhoujie.controller.superadmin;


import com.zhoujie.entity.Area;
import com.zhoujie.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {

    Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    public Map listArea(){
        logger.info("===start===");
        long startTime=System.currentTimeMillis();
        Map<String,Object> map = new HashMap<>();
        List<Area> list = new ArrayList<Area>();
        try {
            list = areaService.getAreaList();
            map.put("rows",list);
            map.put("total",list.size());
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("errMsg",e.getMessage());
        }
        logger.error("test error!");
        long endTime=System.currentTimeMillis();
        logger.debug("costTime:[{}ms]",endTime-startTime);
        logger.info("===end===");
        return map;
    }

}
