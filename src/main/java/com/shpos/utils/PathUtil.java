package com.shpos.utils;

/**
 * Created by likaisong on 2019/4/10.
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath;
        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/projectdev/image/";
        }else {
            basePath = "/Users/likaisong/spring/image/";
        }
        //替换分隔符
        basePath.replace("/", separator);
        return basePath;
    }

    public static String getShopImagePath(int shopId){
        String shopImagePath = "/upload/image/" + shopId + "/";
        return shopImagePath.replace("/", separator);
    }
}
