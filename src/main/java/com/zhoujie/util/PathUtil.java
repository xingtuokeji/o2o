package com.zhoujie.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    private static Logger logger = LoggerFactory.getLogger(PathUtil.class);
    /**
     * 项目图片的根路径
     * @return
     */
    public static String getImgBasePath(){
        String basePath = "";
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/projectdev/image/";
        }else {
            basePath = "/Users/zhoujie/image/";
        }
        basePath = basePath.replace("/",seperator);
        logger.debug(basePath);
        return basePath;
    }

    /**
     * 获取店铺图片的存储路径子路径
     * @return
     */
    public static String getShopImgPath(Long shopId){
         String imagePath = "upload/item/shop"+shopId+"/";
         return imagePath.replace("/",seperator);
    }

}
