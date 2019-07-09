package com.zhoujie.dao;

import com.zhoujie.BaseTest;
import com.zhoujie.entity.Area;
import com.zhoujie.entity.Shop;
import com.zhoujie.entity.ShopCategory;
import com.zhoujie.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop(){
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
        shop.setAdvice("审核中");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setPhone("18806172172");
        shop.setPriority(4);
        shop.setShopAddr("江苏盐城");
        shop.setShopDesc("测试");
        shop.setShopName("大排档");
        shop.setEnableStatus(0);
        int effectNum = shopDao.insertShop(shop);
        if(effectNum != 1){
            System.out.println("插入店铺信息失败");
        }else {
            System.out.println("插入店铺信息成功");
        }
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setAdvice("审核通过");
        shop.setShopName("修改后的店铺名");
        shop.setLastEditTime(new Date());
        shop.setShopId(38L);
        int effectNum = shopDao.updateShop(shop);
        if(effectNum != 1){
            System.out.println("更新店铺信息失败");
        }else {
            System.out.println("更新店铺信息成功");
        }
    }
}
