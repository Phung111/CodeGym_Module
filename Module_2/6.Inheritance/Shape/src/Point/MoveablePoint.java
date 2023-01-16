package Point;

public class MoveablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float []getSpeed(){
        float[] floatArray = {getxSpeed(),getySpeed()};
        return floatArray;
    }
    @Override
    public String toString(){
        return "("
                + getX()
                +", "
                + getY()
                +")"
                +", speed = ("
                + getxSpeed()
                + ", "
                + getySpeed()
                +")";
    }
    public void move(){
        float x = getX();
        float y = getY();
        x += getxSpeed();
        y += getySpeed();
        setX(x);
        setY(y);
    }
}
