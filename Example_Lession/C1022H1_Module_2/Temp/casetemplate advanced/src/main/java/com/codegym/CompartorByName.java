package com.codegym;

import com.codegym.model.Product;

import java.util.Comparator;

public class CompartorByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        // abc bbc
        if (o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()) > 0) {
            return 1;
        }else{
            if (o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()) == 0) {
                return 0;
            }
        }
        return -1;
    }

}
