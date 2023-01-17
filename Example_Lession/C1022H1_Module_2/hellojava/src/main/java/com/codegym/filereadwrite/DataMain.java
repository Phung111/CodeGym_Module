package com.codegym.filereadwrite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataMain {
    public static void main(String[] args) throws ParseException {
        // 2022-12-20
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String sDate = "2022-12-20 08:30:45";
        Date date = simpleDateFormat.parse(sDate);
        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));


    }
}
