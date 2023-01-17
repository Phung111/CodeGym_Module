package com.codegym.fanoop;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    private String id;
    private int speed = SLOW;
    private boolean onOff;
    private double radius;
    private String color = "blue";

    public Fan() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Fan(String id, int speed, boolean onOff, double radius, String color) {
        this.speed = speed;
        this.onOff = onOff;
        this.radius = radius;
        this.color = color;
        this.id = id;
    }

    public Fan(int speed, double radius) {
        this.speed = speed;
        this.radius = radius;
    }
    public String toString() {
        //speed, color, và radius với chuỗi “fan is on”.
        if (this.onOff == true) {
            return "Fan " + this.id + " " + this.speed + " - " + this.color + " - fan is on";
        }else {
            return "Fan " + this.id + " " + "fan is off";
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        if(speed > HIGH){
            this.speed = HIGH;
        }
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
