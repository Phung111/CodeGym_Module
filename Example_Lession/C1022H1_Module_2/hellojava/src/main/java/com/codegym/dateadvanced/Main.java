package com.codegym.dateadvanced;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        String dt = "31-12-2022";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 1);  // number of days to add

        dt = sdf.format(c.getTime());
        System.out.println("--1--");
        System.out.println(dt);



        String dt1 = "02-02-2022";
        Date input = sdf.parse(dt1);
        Instant instant = input.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate date = zdt.toLocalDate();


        String dt2 = "02-03-2022";
        Date input2 = sdf.parse(dt2);
        Instant instant2 = input2.toInstant();
        ZonedDateTime zdt2 = instant2.atZone(ZoneId.systemDefault());
        LocalDate date2 = zdt2.toLocalDate();

        System.out.println("--test isAfter--");
        System.out.println(date.isBefore(date2));

        System.out.println("--test minus day");
        long day = input2.getTime() - input.getTime();
        System.out.println("Day1s:" + TimeUnit.DAYS.convert(day, TimeUnit.MILLISECONDS));
        System.out.println("Day2s:" + (day / (1000*60*60*24)));

        System.out.println("--2--");
        System.out.println(date);
        System.out.println("First day: " + date.withDayOfMonth(1));
        System.out.println("Last day: " + date.withDayOfMonth(date.lengthOfMonth()));

        Date d1 = new Date();       // 28-12-2022 08:33:40
        Date d2 = new Date();       // 28-12-2022 08:33:50

        /**
            Lấy ra những hóa đơn theo từng tháng: 1,2,3,4,5,6,7,8,9,10,11,12
            Lấy ra những hóa đơn theo 2 ngày bất kì: 2022-12-05 -> 2022-12-20
            Lất ra nhưững hóa đơn theo 1 ngày người ta nhập vào: 022-12-05

         */



    }
}
