package com.codegym.collections;

public class ChildProduct extends Product{
    public static void main(String[] args) {
        Product p = (Product) new Object();
        ChildProduct [] childProducts = (ChildProduct[]) new Product[5] ;
        System.out.println(childProducts);



    }
}

