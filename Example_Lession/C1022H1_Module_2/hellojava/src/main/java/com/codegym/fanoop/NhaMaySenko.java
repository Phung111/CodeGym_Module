package com.codegym.fanoop;

import java.util.Scanner;

public class NhaMaySenko {
    Scanner scanner = new Scanner(System.in);
    private Fan [] fans;
    public NhaMaySenko() {

    }
    public void sanxuatQuat() {
        fans = new Fan[5];
        //public Fan(int speed, boolean onOff, double radius, String color)
        Fan fan1 = new Fan("SK1" , Fan.SLOW, false, 50.0, "Red");
        Fan fan2 = new Fan("SK2", Fan.SLOW, false, 50.0, "Blue");
        Fan fan3 = new Fan("SK3", Fan.SLOW, false, 50.0, "Red");
        Fan fan4 = new Fan("SK4", Fan.SLOW, false, 50.0, "Red");
        Fan fan5 = new Fan("SK5", Fan.SLOW, false, 50.0, "Red");

        fans[0] = fan1;
        fans[1] = fan2;
        fans[2] = fan3;
        fans[3] = fan4;
        fans[4] = fan5;
        Fan newFan = new Fan();
        System.out.println("Nhập tốc độ quạt.");
        int speed = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập màu sắc");
        String color = scanner.nextLine();
        System.out.println("Nhập bán kính quạt");
        double radius = Double.parseDouble(scanner.nextLine());
        newFan.setColor(color);
        newFan.setSpeed(speed);
        newFan.setRadius(radius);
        newFan.setOnOff(true);
        newFan.setId("SK" + (fans.length+1));
        Fan[] newFans = new Fan[fans.length+1];
            for (int i = 0; i<newFans.length; i++){
                if (i == newFans.length-1){
                    newFans[i] = newFan;
                }else {
                    newFans[i] = fans[i];
                }
            }
            fans = newFans;
            showFanOn();



        showFanOn();

        // Bật những cái quạt theo màu:
        turnOnByColor("Red");
        turnOnByColor("Blue");

        showFanOn();
        upSpeedByColor("Red");
        upSpeedByColor("Red");
        upSpeedByColor("Red");
        showFanOn();

    }
    public void upSpeedByColor(String color){
        for(int i = 0; i < fans.length; i++){
            if(fans[i].getColor().equals(color)){
                int speedOld = fans[i].getSpeed();
                fans[i].setSpeed(++speedOld);
            }
        }
    }
    public void turnOnByColor(String color){
        for (int i =0; i < fans.length; i++){
            if(fans[i].getColor().equals(color)){
                fans[i].setOnOff(true);
            }
        }
    }
    public void showFanOn() {
        for (int i = 0; i < fans.length; i++) {
            if (fans[i].isOnOff()) {
                System.out.println(fans[i].toString());
            }
        }
    }
    public static void main(String[] args) {
        NhaMaySenko nhaMaySenko = new NhaMaySenko();
        nhaMaySenko.sanxuatQuat();
    }
}
