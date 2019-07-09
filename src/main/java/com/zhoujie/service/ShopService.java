package com.zhoujie.service;

import com.zhoujie.dto.ShopExecution;
import com.zhoujie.entity.Shop;

import java.io.InputStream;

public interface ShopService {

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName);
}
