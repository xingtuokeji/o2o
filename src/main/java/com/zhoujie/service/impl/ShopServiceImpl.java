package com.zhoujie.service.impl;

import com.zhoujie.dao.ShopDao;
import com.zhoujie.dto.ShopExecution;
import com.zhoujie.entity.Shop;
import com.zhoujie.enums.ShopStateEnum;
import com.zhoujie.exceptions.ShopOperationException;
import com.zhoujie.service.ShopService;
import com.zhoujie.util.ImageUtil;
import com.zhoujie.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;


    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
        if(shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectNum = shopDao.insertShop(shop);
            if(effectNum <= 0){
                throw new ShopOperationException("店铺创建失败");
            }
            if(shopImgInputStream!=null){
                //存储图片
                addShopImg(shop,shopImgInputStream,fileName);
                effectNum = shopDao.updateShop(shop);
                if(effectNum <= 0){
                    throw new ShopOperationException("更新图片地址失败！");
                }
            }
        }catch (Exception e){
            throw new ShopOperationException("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName) {
        String dest = PathUtil.getShopImgPath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
