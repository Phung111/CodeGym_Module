package com.codegym.demo;

import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void showCalendar(Calendar c) {
        int year = c.get(Calendar.YEAR);

        // Trả về giá trị từ 0 - 11
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int millis = c.get(Calendar.MILLISECOND);

        System.out.println(" " + year + "-" + (month + 1) + "-" + day //
                + " " + hour + ":" + minute + ":" + second + " " + millis);
    }
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        Calendar c = Calendar.getInstance();
        c.setTime(now);

        System.out.println("Start..........: ");
        showCalendar(c);
        c.add(Calendar.MINUTE, 1 * 60 + 30);
        System.out.println("End..........: ");
        showCalendar(c);

        Date d1 = c.getTime();
        System.out.println(d1);
    }
}
