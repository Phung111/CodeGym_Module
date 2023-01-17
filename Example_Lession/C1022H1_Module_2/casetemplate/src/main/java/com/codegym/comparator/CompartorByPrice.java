package com.codegym.comparator;

import com.codegym.model.Product;

import java.util.Comparator;

public class CompartorByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o1.getPrice()) {
            return 1;
        }else{
            if (o1.getPrice() == o2.getPrice()) {
                return 0;
            }
        }
        return -1;
    }
}
