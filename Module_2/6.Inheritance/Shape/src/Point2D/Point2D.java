package Point2D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }
    public Point2D(float x, float y) {
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
        return "Coordinates of 2D point: ("
                + getX()
                +", "
                + getY()
                + ")";
    }
}
