package com.shpos.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by likaisong on 2019/4/10.
 */
public class ImageUtil {

    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class.getName());
    //resource路径
    private static String resourcePath = ClassLoader.getSystemResource("").getPath();

    public static String generatorThumbnaila(File thumbnaila, String fileDir) {
        //创建上传文件目录
        makeDirPath(fileDir);
        //随机文件名
        String fileName = getRandomFileName();
        //文件后缀格式
        String extension = getFileExtension(thumbnaila);
        //图片相对路径
        String relativeAddr = fileDir + fileName + extension;
        logger.debug("图片相对路径：" + relativeAddr);
        //图片绝对路径（存储路径）
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("图片绝对路径：" + dest.getPath());
        try {
            Thumbnails.of(thumbnaila)
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(resourcePath + "/watermark.png")), 0.5f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建上传文件目录
     * @param fileDir
     */
    private static void makeDirPath(String fileDir) {
        String realPath = PathUtil.getImgBasePath() + fileDir;
        File dirPath = new File(realPath);
        logger.debug("文件目录：" + dirPath.getPath());
        if (! dirPath.exists()){
            //逐级创建
            dirPath.mkdirs();
        }
    }

    /**
     * 获取文件扩展名
     * @param thumbnaila
     * @return
     */
    private static String getFileExtension(File thumbnaila) {
        String fileName = thumbnaila.getName();
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 当前时间+五位随机数
     *
     * @return
     */
    private static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int ranNum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        return ranNum + str;
    }
}
