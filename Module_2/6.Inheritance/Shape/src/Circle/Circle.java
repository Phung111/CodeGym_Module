package Circle;

public class Circle {
    private int radius;
    private String color;
    public Circle(){

    }
    public Circle(int radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int getArea(){
        return (int) (this.radius*this.radius*3.14);
    }
    @Override
    public String toString(){
        return "A circle with radius = "
                + getRadius()
                + " and color "
                + getColor();
    }
}
