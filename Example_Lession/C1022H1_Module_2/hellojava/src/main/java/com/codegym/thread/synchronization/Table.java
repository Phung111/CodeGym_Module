package com.codegym.thread.synchronization;

public class Table {
    void  printTable(int n) {// method không synchronized
        synchronized (this) {// Khoi dong bo (synchronized block)
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
