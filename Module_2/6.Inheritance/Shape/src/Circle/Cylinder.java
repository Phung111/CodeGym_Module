package Circle;

public class Cylinder extends Circle{
    public int high;
    public Cylinder(){

    }
    public Cylinder(int high){
        this.high = high;
    }
    public Cylinder(int high, int radius, String color){
        super(radius, color);
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
    public int getVolume(){
        return super.getArea()*this.high;
    }
    @Override
    public String toString(){
        return "A cyclinder with radius = "
                + this.getRadius()
                + ", high = "
                + this.high
                + " and color "
                + this.getColor()
                + ", which is a subclass of "
                + super.toString();
    }
}
