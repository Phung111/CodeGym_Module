package com.codegym.fanoop;

import java.util.Scanner;

public class StopWatch {
    private long startTime;
    private long endTime;

    StopWatch() {
        this.startTime  = System.currentTimeMillis();
    }
    public void startTime(){
        this.startTime  = System.currentTimeMillis();
    }

    public void stopTime() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        System.out.println("Bat dau bam gio");
        stopWatch.startTime();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ket thuc");
        String kt = scanner.nextLine();
        if (kt.equals("OK")) {
            stopWatch.stopTime();
            System.out.println("Đa troi qua: " + stopWatch.getElapsedTime()/1000);

        }
    }

}
