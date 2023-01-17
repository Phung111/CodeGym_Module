package com.codegym.repository.file;

import com.codegym.model.Product;

public class ProductRepository extends FileContext<Product> {
    public ProductRepository() {
        filePath = "./data/product.txt";
        tClass = Product.class;
    }
}
