package com.nepxion.permission.utils;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jinchengyang.jcy
 * 2018-06-29
 * 编号生成器
 */
@Component
public class CodeGenerator {
    public static String POSITION = "POSITION";
    public static String ROLE = "ROLE";
    public static String PERMISSION = "PERMISSION";
    public static String RESOURCE = "RESOURCE";

    public static String generatorCodeSerial(String prefix, Long id) {
        return generatorCodeSerial(prefix, new Date(), id);
    }

    public static String generatorCodeSerial(String prefix, Date date, Long id) {

        Long base = 1000000000000L;

        StringBuilder orderSerialBuilder = new StringBuilder(prefix);
        String calender = new DateTime(date).toString("yyyyMMdd");
        return orderSerialBuilder
                .append(calender)
                .append(String.format("%012d", id % base))
                .toString();
    }


}
