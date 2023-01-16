import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello: " + name);
    }
}