package Point;

public class Point {
    static private float x = 0.0f;
    static private float y = 0.0f;

    public Point() {
    }
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float[] getXY(){
        float[] floatArray = {this.x, this.y};
        return floatArray;
    }

    @Override
    public String toString(){
        return "Coordinates of point: ("
                + getX()
                +", "
                + getY()
                + ")";
    }
}
