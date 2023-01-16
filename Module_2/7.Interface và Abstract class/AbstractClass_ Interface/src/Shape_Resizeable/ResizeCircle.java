package Shape_Resizeable;

//import Shape_Resizeable.Circle;
//import java.util.Arrays;

public class ResizeCircle {
    public static void main(String[] args) {
        Circle[] circles = new Circle[2];
        circles[0] = new Circle(1);
        circles[1] = new Circle(10);

        for (Circle circle : circles){
            System.out.println(circle.getArea());
        }

        for (Circle circle : circles){
            System.out.println(circle.resize((double) 2));
        }
    }
}
