package com.shpos.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

    private static String basePath = ClassLoader.getSystemResource("").getPath();

    public static void generatorThumbnaila(CommonsMultipartFile thumbnaila, String fileDir) {
        String fileRealName = getRandomFileName();
        String extension = getFileExtension(thumbnaila);
        makeDirPath(fileDir);
        String relativeAddr = fileDir + fileRealName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnaila.getInputStream())
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.5f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建上传文件目录
     * @param fileDir
     */
    private static void makeDirPath(String fileDir) {
        String realPath = PathUtil.getImgBasePath() + fileDir;
        File dirPath = new File(realPath);
        if (! dirPath.exists()){
            dirPath.mkdir();
        }
    }

    /**
     * 获取文件扩展名
     * @param thumbnaila
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile thumbnaila) {
        String fileName = thumbnaila.getOriginalFilename();
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
