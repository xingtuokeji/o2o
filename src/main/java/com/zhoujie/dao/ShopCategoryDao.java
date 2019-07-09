package com.zhoujie.dao;

import com.zhoujie.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {

    // 参数shopCategoryCondition不要写成ShopCategoryCondition
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
