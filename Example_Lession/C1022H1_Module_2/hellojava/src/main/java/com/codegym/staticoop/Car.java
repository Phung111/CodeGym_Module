package com.codegym.staticoop;

public class Car {

    private String name;
    private String engine;
    public static int numberOfCars;


    public Car() {


    }
    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;

    }

    public static void main(String[] args) {
        Car car = new Car("audi", "v1");
        Car car1 = new Car("audi1", "v1");
    }

}