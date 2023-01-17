package com.codegym.javabuoi123;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("Nhap ho ten:");
        // int, long, byte, short        --> 5, 7, -5
        // double, float        --> 4.5, 6.77
        // char                 --> 'c', 'A'
        // boolean              --> true, false

        // let a = 5;
        // let b = false;


        // 46000.6789


        System.out.println("UCLN: " + timUCLN(18,72));

    }

    public static int timUCLN(int a, int b) {
        int max = 0;
        int min = 0;
        if (a < b) {
            min = a;
        }else{
            min = b;
        }
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                max = i;
            }
        }
        return max;
    }

    public static void chuyenTienTe() {
        System.out.println("Nhap so tien $: ");
        double soTienDo = scanner.nextDouble();
        System.out.println("So tien VND: " + (int) (soTienDo * 23000.457));
    }
    public static void chuyenTienTeCoLamTro() {
        // Math: round(), random() 0<x<1, abs(): trị tuyêt đối
        // pow() hàm mũ, ceil () làm tron len, floor () làm trong xuong
        System.out.println("Nhap so tien $: ");
        double soTienDo = scanner.nextDouble();
        System.out.println("So tien VND: " + Math.round(soTienDo*23000.463));
    }
    public static void nhapSoLuong1() {
        int number = -1;
        do {
            System.out.println("Nhap so luong:");
            number = scanner.nextInt();
            System.out.println("So luong: " + number);
            if (number < 10) {
                System.out.println("So luong khong duoc nho hon 10. Vui long nhap lai");
            }
        } while (number < 10);
    }
    public static void nhapSoLuong2() {
        int number = -1;
        int count = 0;
        do {
            System.out.println("Nhap so luong:");
            number = scanner.nextInt();
            System.out.println("So luong: " + number);
            if (number < 10) {
                System.out.println("So luong khong duoc nho hon 10. Vui long nhap lai");
            } else {
                count ++;
            }
        } while (count < 3);
    }

    public static void nhapSoLuong3() {
        int number = -1;
        do {
            System.out.println("Nhap so luong:");
            number = scanner.nextInt();
            System.out.println("So luong: " + number);
            if (number < 10) {
                System.out.println("So luong khong duoc nho hon 10. Vui long nhap lai");
            }
            System.out.println("Ban co muon tiep tuc hay khong. Yes(Y) / No (N)");
            String actionContinue = scanner.nextLine();
            if (actionContinue == "Y") {
                number = -1;
            }else{
                number  = 11;
            }
        } while (number < 10);
    }

    public static void nhapSoLuong4() {
        int number = -1;
        boolean checkInputQuantity = false;
        do {
            System.out.println("Nhap so luong:");
            number = Integer.parseInt(scanner.nextLine());
            System.out.println("So luong: " + number);
            if (number < 10) {
                System.out.println("So luong khong duoc nho hon 10. Vui long nhap lai");
                checkInputQuantity = true;
            }
            System.out.println("Ban co muon tiep tuc hay khong. Yes(Y) / No (N)");
            String actionContinue = scanner.nextLine();
            // Nhớ so sánh chuỗi thì dùng hàm equals không dùng ==
            if (actionContinue.equals("Y")) {
                checkInputQuantity = true;
            }else{
                checkInputQuantity = false;
            }
        } while (checkInputQuantity);
    }
    public static void nhapTen() {
        System.out.println("Nhap ten:");
        String name = scanner.nextLine();
        System.out.println("Toi ten la: " + name);
    }
}