package Circle;

import Shape.Shape;

public class CyclinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5,2,"red");
        System.out.println(cylinder);

        System.out.println(cylinder.getVolume());
    }
}
