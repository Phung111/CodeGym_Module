package com.codegym.thread.extendthread;

public class PrintNumberThread extends Thread{

    private int number;

    public PrintNumberThread(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println("PrintNumber ...." + i);
        }
    }
}
