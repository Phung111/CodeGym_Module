public class Fan {

    int slow = 1;
    int medium = 2;
    int fast = 3;

    private int speed = slow;
    private boolean onOff = false;
    private double radius = 5;
    private String color = "blue";
    public Fan(int speed, boolean onOff, double radius, String color){
        this.speed = speed;
        this.onOff = onOff;
        this.radius = radius;
        this.color = color;
    }
    public Fan(int speed, double radius){
        this.speed = speed;
        this.radius = radius;
    }


}
