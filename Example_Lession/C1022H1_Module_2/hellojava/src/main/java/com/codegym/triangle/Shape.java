package com.codegym.triangle;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    // Trong lớp trừu tượng vẫn có thể có contructor
    // Trong lớp trừu tượng vẫn có phương thuc va thuộc tính bình thường
    public Shape() {

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled =filled;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    // Phương thức trừu tượng: sẽ ko có phần thân
    // Nếu trong 1 lớp có 1 phương thức trưu tượng thì lớp đó là lớp trừu tuợng
}
