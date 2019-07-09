package com.zhoujie.service;

import com.zhoujie.BaseTest;
import com.zhoujie.dto.ShopExecution;
import com.zhoujie.entity.Area;
import com.zhoujie.entity.Shop;
import com.zhoujie.entity.ShopCategory;
import com.zhoujie.entity.User;
import com.zhoujie.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void testAddAShop() throws FileNotFoundException {
        Shop shop = new Shop();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        User user = new User();
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        user.setUserId(2L);
        shop.setArea(area);
        shop.setOwner(user);
        shop.setShopCategory(shopCategory);
        shop.setAdvice("审核中8");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setPhone("18806172172");
        shop.setPriority(48);
        shop.setShopAddr("江苏盐城88");
        shop.setShopDesc("测试88");
        shop.setShopName("大排档88");
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        File shopImg = new File("/Users/zhoujie/Desktop/zhoujie.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop,is,shopImg.getName());
        System.out.println(se.getState()==0);

    }
}
