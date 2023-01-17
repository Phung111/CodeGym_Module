package com.codegym.collections;

import java.util.*;

//
public class MyArrayList<T> {
    private int size = 0;
    private T[] elements;           // Moi che
    private Object[] items;         // Cach JAMES
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        items = new Object[DEFAULT_CAPACITY];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>();
        array.addT(2);

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(10);
        arr.add(3);
        arr.add(6);
        arr.add(7);

        MyArrayList<Integer> ds = new MyArrayList<>();
//        ds.add(1);
//        ds.add(10);
//        ds.add(3);
//        ds.add(6);
//        ds.add(7);
        ds.addAll(arr);

        ds.remove(2);
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(T e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public T get(int index) {
        return (T) elements[index];
    }

    public void addT(T e) {
        if (size == items.length) {
            int newSize = items.length * 2;
            items = Arrays.copyOf(items, newSize);
        }
        items[size++] = e;
    }
    public void add(T item, int index) {
        if(size > elements.length){
            ensureCapa();
        }
        for(int i = size-1; i > index ; i--){
            elements[i+1] = elements[i];
        }
        elements[index]=item;
        size++;
    }
    public void remove(int index){
        for(int i = index; i<size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1]=null;
        size--;
    }

    public void addAll(Collection<T> collection) {
        Iterator<T> interator = collection.iterator();
        while (interator.hasNext()) {
            add(interator.next());
        }

    }



}
