package Shape;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea(){
        return this.width*this.length;
    }
    public double getPerimeter(){
        return (this.width+this.length)*2;
    }
    @Override
    public String toString(){
        return "A Retangle with width = "
                + this.width
                + " and length = "
                + this.length
                + ", which is a subclass of "
                + super.toString();
    }
}
