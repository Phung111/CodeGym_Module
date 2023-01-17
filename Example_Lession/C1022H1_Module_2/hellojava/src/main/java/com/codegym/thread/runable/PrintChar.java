package com.codegym.thread.runable;

public class PrintChar implements Runnable{

    private char charToPrint;
    private int number;

    public PrintChar(int number, char charToPrint) {
        this.number = number;
        this.charToPrint = charToPrint;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println("PrintChar" + charToPrint + " ..." + i);
        }
    }
}
