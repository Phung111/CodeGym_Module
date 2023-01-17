package com.codegym.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 8, 9};
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    arr[j+1] = arr[j];
                }else{
                    arr[j] = temp;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int indexMin = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < min) {
                    min = arr[j];
                    indexMin = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
    }

    public static void bubleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1]= temp;
                }
            }
        }
    }


}
