package com.codegym.javabuoi123;

public class Arrray {
    public static void main(String[] args) {


    }

    public static int tinhTongHinhVuongNgoai(int[][] arr2) {
        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum += arr2[0][i];
            sum += arr2[arr2.length - 1][i];
            sum += arr2[i][0];
            sum += arr2[i][arr2.length - 1];
        }
        sum = sum - arr2[0][0] - arr2[0][arr2.length - 1] - arr2[arr2.length - 1][0] - arr2[arr2.length - 1][arr2.length - 1];
        return sum;
    }

    public static int tinhTongTamGiacDuoi(int[][] arr2) {
        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = arr2[i].length - i - 1; j >= 0; j--) {
                sum += arr2[i][j];
            }
        }
        return sum;
    }

    public static int tinhTong2DuongCheoChinh(int[][] arr2) {
        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if ((i == j) || ((i + j) == arr2[i].length - 1)) {
                    sum += arr2[i][j];
                }
            }
        }
        return sum;
    }

    public static void printArray2(int[][] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (j != arr2[i].length - 1) {
                    System.out.print(arr2[i][j] + ",");
                } else {
                    System.out.print(arr2[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

    public static int[][] initArray2(int row, int col, int max, int min) {
        int[][] arr2 = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr2[i][j] = (int) (Math.random() * (max - min + 1) + min);
            }
        }
        return arr2;
    }

    public static int[][] initArray2() {
        int[][] arr2 = {
                {5, 6, 1, 3, 6},
                {3, 6, 9, 9, 2},
                {9, 7, 7, 8, 2},
                {8, 4, 2, 5, 2},
                {1, 9, 6, 2, 6}
        };
        return arr2;
    }

    public static void addElementToArray(int index, int value, int[] arr) {
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            arrNew[i] = arr[i];
        }
        arrNew[index] = value;
        for (int i = index + 1; i < arrNew.length; i++) {
            arrNew[i] = arr[i - 1];
        }
        arr = arrNew;
    }

    public static void spiceArrayIndex(int index, int[] arr) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public static String findIndexMaxArray(int[] arr) {
        String str = "";
        int max = arr[0];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            max = arr[0];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= max) {
                    max = arr[j];
                    k = j;
                }
            }
            if (arr[i] == max) {
                str += i;
                if (i != k) {
                    str += ",";
                }
            }
        }
        return str;
    }

    public static int[] initArray(int size, int max, int min) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
