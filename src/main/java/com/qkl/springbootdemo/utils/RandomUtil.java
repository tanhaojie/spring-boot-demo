package com.qkl.springbootdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtil {

    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return
     */
    public static String getImgName() {

        Date dt = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName = sdf.format(dt);
        return fileName;
    }

    public static void main(String[] args) {

        String fileName = RandomUtil.getImgName();
        System.out.println(fileName);

    }

}
