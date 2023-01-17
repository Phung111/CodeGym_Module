package com.codegym.triangle;

public class SortUtils {
    public  static <T> void sort(T[] items, MyComparator myComparator) {
        for (int i=0; i< items.length-1;i++) {
            for (int j = i + 1; j < items.length; j++) {
                // Tạo 1 phương thức so sánh --> HẮN TRƯU TUONG
                if (myComparator.myComparaTo(items[i], items[j]) == 1) {
                    T temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
    }
    public  static <T> void sort(T[] items) {
        for (int i=0; i< items.length-1;i++) {
            for (int j = i + 1; j < items.length; j++) {
                // Tạo 1 phương thức so sánh --> HẮN TRƯU TUONG
                MyComparable<T> a1 = (MyComparable<T>) items[i];
                MyComparable<T> a2 = (MyComparable<T>) items[j];
                if (a1.compare(items[j]) == 1) {
                    T temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
    }

}
