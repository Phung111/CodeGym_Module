package Point2D;

public class Point3D extends Point2D{
    private float z;

    public Point3D() {
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] setXYZ(float x, float y, float z){
        float[] floatArray = {getX(),getY(),getZ()};
        return floatArray;
    }

    @Override
    public String toString(){
        return "Coordinates of 3D point: ("
                + getX()
                +", "
                + getY()
                +", "
                + getZ()
                + ")";
    }
}
