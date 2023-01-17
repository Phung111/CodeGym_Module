package com.codegym.thread.extendthread;

import javax.swing.plaf.TableHeaderUI;

public class PrintCharThread extends Thread{

    private char charToPrint;
    private int number;

    public PrintCharThread(int number, char charToPrint) {
        this.number = number;
        this.charToPrint = charToPrint;
    }
    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println("PrintCharThread" + charToPrint + " ..." + i);
        }
    }
}
