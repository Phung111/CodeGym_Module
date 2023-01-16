package Point;

public class TestPoint {
    public static void main(String[] args) {
        Point point = new Point(2,3);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(1,1);
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);

    }
}
