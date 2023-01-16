import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Counter2 c1 = new Counter2();
        Counter2 c2 = new Counter2();
        Counter2 c3 = new Counter2();


    }

    public static void QuadraticEquation(){
        Scanner scanner = new Scanner(System.in);
        int a = 1;
        int b = 2;
        int c = 2;
        QuadraticEquation myQuadratic = new QuadraticEquation(a,b,c);
        int delta = myQuadratic.getDiscriminant();

        System.out.println(a + "x2 + " + b + "x + " + c + " = 0");
        if (delta < 0) {
            System.out.println("The equation has no roots");
        } else if (delta == 0){
            System.out.println("x1 = x2 =" + (int)(-b/(2*a)));
        } else {
            System.out.println("x1 = " + myQuadratic.getRoot1() + " ,x2 =" + myQuadratic.getRoot2());
        }
    }
    public static void StopWatch(){
        StopWatch time = new StopWatch();
        time.startTime();
        time.start();
        time.stop();
        time.getElapsedTime();
        System.out.println(time.startTime());
        System.out.println(time.start());
        System.out.println(time.stop());
        System.out.println(time.getElapsedTime());
    }
}