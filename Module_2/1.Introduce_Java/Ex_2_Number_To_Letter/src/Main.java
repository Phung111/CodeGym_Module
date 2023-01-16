
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number to read:");
        double number = scanner.nextDouble();
        if (number == 0) {
            System.out.println("zero");
        } else if (0 < number && number < 10) {
            System.out.println(docSoBeHon10((int) number));
        } else if (10 <= number && number < 20) {
            System.out.println(docSoBeHon20((int) number));
        } else if (20 <= number && number < 100) {
            System.out.println(docSoBeHon100((int) number));
        } else if (100 <= number && number < 1000){
            System.out.println(docSoBeHon1000((int) number));
        }

    }

    public static String docSoBeHon10(int number) {
        String read;
        switch ((int) number) {
            case 0:
                read = "";
                break;
            case 1:
                read = "one";
                break;
            case 2:
                read = "two";
                break;
            case 3:
                read = "three";
                break;
            case 4:
                read = "four";
                break;
            case 5:
                read = "five";
                break;
            case 6:
                read = "six";
                break;
            case 7:
                read = "seven";
                break;
            case 8:
                read = "eight";
                break;
            case 9:
                read = "nine";
                break;
            default:
                read = "out of ability";
        }
        return read;
    }

    public static String docSoBeHon20(int number) {
        int donvi = number % 10;
        String read;
        switch ((int) donvi) {
            case 0:
                read = "ten";
                break;
            case 1:
                read = "eleven";
                break;
            case 2:
                read = "twelve";
                break;
            case 3:
                read = "thirteen";
                break;
            case 4:
                read = "fourteen";
                break;
            case 5:
                read = "fifteen";
                break;
            case 6:
                read = "sixteen";
                break;
            case 7:
                read = "seventeen";
                break;
            case 8:
                read = "eighteen";
                break;
            case 9:
                read = "nineteen";
                break;
            default:
                read = "out of ability";
        }
        return read;
    }

    public static String docSoBeHon100(int number) {
        int chuc = number / 10;
        int donvi = number % 10;
        String read;
        String read99;
        switch ((int) chuc) {
            case 0:
                read99 = "";
                break;
            case 2:
                read99 = "twenty";
                break;
            case 3:
                read99 = "thirty";
                break;
            case 4:
                read99 = "forty";
                break;
            case 5:
                read99 = "fifty";
                break;
            case 6:
                read99 = "sixty";
                break;
            case 7:
                read99 = "seventy";
                break;
            case 8:
                read99 = "eighty";
                break;
            case 9:
                read99 = "ninety";
                break;
            default:
                read99 = "out of ability";
        }
        String read10 = docSoBeHon10((int) donvi);
        return read = (String) read99 +" "+ (String) read10;
    }

    public static String docSoBeHon1000(int number) {
        int tram = number / 100;
        int chucVaDonvi = number % 100;
        String read;
        String read999;
        switch ((int) tram) {
            case 0:
                read999 = " ";
                break;
            case 1:
                read999 = "one hundred";
                break;
            case 2:
                read999 = "two hundred";
                break;
            case 3:
                read999 = "three hundred";
                break;
            case 4:
                read999 = "four hundred";
                break;
            case 5:
                read999 = "five hundred";
                break;
            case 6:
                read999 = "six hundred";
                break;
            case 7:
                read999 = "seven hundred";
                break;
            case 8:
                read999 = "eight hundred";
                break;
            case 9:
                read999 = "nine hundred";
                break;
            default:
                read999 = "out of ability";
        }

        String read100 = docSoChucVaDonvi((int) chucVaDonvi);
        return read = (String) read999 +" "+ (String) read100;

    }

    public static String docSoChucVaDonvi (int number) {
        if (number <10){
            return docSoBeHon10(number);
        } else if (number <20) {
            return docSoBeHon20(number);
        } else {
            return docSoBeHon100(number);
        }
    }
}