package com.codegym.longtoan;

public class Search {
    public static void main(String[] args) {
        double [] arr = {-5.0, 17, -8.0, 5, -50, 1,1};
        double number =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                number = arr[i];
            }
        }
        System.out.println(number);
    }
    public void bai183() {
        double [] arr = {-5.0, 17, 8.0, 5};

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            }else{
                if (arr[i] > Math.abs(arr[i + 1])) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
    public void bai184() {
        double [] arr = {-5.0, 17, 8.0, 5, 17};

        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                System.out.println(i);
            }
        }
    }
    public void bai135() {
        double [] arr = {-5.0, 17, -8.0, 5, -50};
        double sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && count < 2) {
                sum += arr[i];
                count ++;
            }
            if (count == 2) {
                break;
            }
        }
        System.out.println(sum);
    }
}
