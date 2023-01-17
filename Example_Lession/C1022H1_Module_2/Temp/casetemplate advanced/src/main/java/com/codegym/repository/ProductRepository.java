package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.Date;

public class ProductRepository extends DatabaseContext<Product> {
    @Override
    public void init() {
        list = new ArrayList<>();
        //long id, String name, double price, int quantity, Date createAt
        list.add(new Product(1671692231, "A Iphone", 90000, 2, new Date()));
        list.add(new Product(1671692232, "Uphone 11", 10000, 2, new Date()));
        list.add(new Product(1671692233, "Bphone 12", 50000, 2, new Date()));
        list.add(new Product(1671692234, "Aphone 13", 30000, 2, new Date()));
    }
}
