package com.codegym.thread;

import com.codegym.thread.extendthread.PrintCharThread;
import com.codegym.thread.extendthread.PrintNumberThread;
import com.codegym.thread.runable.PrintChar;
import com.codegym.thread.runable.PrintNumber;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Dùng cách triển khai từ interface Runable
         Runnable r1 = new PrintChar(100, 'a');
         Runnable r2 = new PrintChar(500, 'e');
         Runnable r3 = new PrintNumber(700);
         Thread thread1 = new Thread(r1);
         Thread thread2 = new Thread(r2);
         Thread thread3 = new Thread(r3);

         thread1.start();
         thread2.start();
         thread3.start();

         Thread t1 = new PrintCharThread(100, 'a');
         Thread t2 = new PrintCharThread(500, 'e');
         Thread t3 = new PrintNumberThread((700));

         t1.start();
         t2.start();
         t3.start();

         */

        Thread t1 = new PrintCharThread(100, 'a');
        Thread t2 = new PrintCharThread(500, 'e');
        Thread t3 = new PrintNumberThread((700));

        t1.start();
        t2.start();
        t3.start();


    }
}
