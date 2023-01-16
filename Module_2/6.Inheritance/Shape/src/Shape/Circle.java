package Shape;

public class Circle extends Shape {
    private double radius = 1.0;
     public Circle(){

     }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public String getColor(){
         return color;
    }
    public boolean getFilled(){
         return filled;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString(){
         return "A Circle with radius = "
                 + getRadius()
                 + " which is a subclass of"
                 + super.toString();
    }
}
