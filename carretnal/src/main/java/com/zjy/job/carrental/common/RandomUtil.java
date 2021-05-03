package com.zjy.job.carrental.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数生成util
 **/
public class RandomUtil {
    private static final SimpleDateFormat dateFormatOne=new SimpleDateFormat("yyyyMMddHHmmssSSS");

    private static final ThreadLocalRandom random=ThreadLocalRandom.current();

    /**
     * 生成订单编号
     * @return
     */
    public static String generateOrderCode(){
        return dateFormatOne.format(new Date()) + generateNumber(4);
    }

    /**
     * 生成指定位数的随机数
     * @param num 位数
     * @return
     */
    public static String generateNumber(final int num){
        StringBuffer sb=new StringBuffer();
        for (int i=1;i<=num;i++){
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }
}