package com.codegym.triangle;

public class Rectangle extends Shape implements MyComparable<Rectangle>{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    // Nếu không muốn ghi đè phương trừu tượng của lớp cha thì mình chuyển lớp con thành lớp trưu tươg
    // Nếu 1 lớp con kế thừa lớp cha là truu tương thì phải ghi đè phương thức trừu tuợng của lớp cha
    @Override
    public double getArea() {
        return this.height*this.width;
    }
    public double getPerimeter() {
        return this.height*this.width;
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle W: %s H: %s - DT: %s", this.width, this.height, this.getArea());
    }
    public String toStringChuVi() {
        return String.format("Rectangle W: %s H: %s - CV: %s", this.width, this.height, this.getPerimeter());
    }


    @Override
    public int compare(Rectangle obj) {
        if (this.getArea() > obj.getArea()) {
            return 1;
        }else{
            if (this.getArea() == obj.getArea()) {
                return 0;
            }
        }
        return -1;
    }
}
