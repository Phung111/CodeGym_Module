package com.codegym.javabuoi123;

import java.util.Scanner;

public class Loop {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ban can tinh tong bao nhieu so nguyen to dau tien: ");
        int number = scanner.nextInt();
        int sum = 0;
        // 2,3,4,5,6,78
        // sum = 2+3+5+7+11

        // 2+3+5+7+11

    }


    public static int getTotalNumberFirstPrime(int number) {
        int sum = 0;

        int i = 2;
        int count = 0;
        String str = "";
        while (count < number) {
            if(checkPrime(i)){
                sum += i;
                count++;
                str += i;
                if (count != number) {
                    str += "+";
                }
            }
            i++;

        }
        return sum;
    }
    public static void numberFirstPrime(int number) {
        int count = 0;
        for (int i = 2;count < number; i++) {
            if (checkPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
    }
    public static boolean checkPrime(int number) {
        boolean  checkPrime = true;
        if (number < 2) {
            checkPrime = false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                checkPrime = false;
                break;
            }
        }
        return checkPrime;
    }
}
