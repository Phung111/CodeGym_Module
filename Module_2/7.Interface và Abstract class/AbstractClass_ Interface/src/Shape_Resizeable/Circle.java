package Shape_Resizeable;

public class Circle implements Resizeable{
    public double radius;
    public String color;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public boolean filled;


    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public double getRadius(){

        return radius;
    }
    public double getArea(){

        return 3.14*getRadius()*getRadius();
    }
    @Override
    public String toString(){
        return "A Circle with radius = "
                + getRadius();
    }
    @Override
    public double resize(double size) {
        this.radius = getRadius()*size;
        return getArea()*size;
    }


}
