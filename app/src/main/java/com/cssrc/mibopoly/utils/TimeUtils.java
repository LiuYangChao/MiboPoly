package com.cssrc.mibopoly.utils;

/**
 * Author liuyangchao
 * Date on 2017/4/11.10:35
 */

public class TimeUtils {

    public static String transDuration(int time){
        int mm = time/60;       //分钟
        int ss = time%60;           //秒
        String second = "";
        String minute = "";
        if (ss < 10) {
            second = "0" + String.valueOf(ss);
        } else {
            second = String.valueOf(ss);
        }
        if (mm < 10) {
            minute = "0" + String.valueOf(mm);
        } else {
            minute = String.valueOf(mm);//分钟
        }
        return minute+"'"+second+"''";
    }

}
