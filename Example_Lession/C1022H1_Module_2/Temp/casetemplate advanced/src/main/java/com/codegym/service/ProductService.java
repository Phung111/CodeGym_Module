package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ISearch;
import com.codegym.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository;
    public ProductService() {
        productRepository = new ProductRepository();
    }
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }


    public List<Product> searchProductsByName(String name) {
        ISearch<Product> iSearch = new ISearch<Product>() {
            @Override
            public boolean searchByName(Product obj, String name) {
                if (obj.getName().toUpperCase().contains(name.toUpperCase())) {
                    return true;
                }
                return false;
            }
        };
        return productRepository.searchByName(iSearch, name);
    }
    public void deleteProductById(long idProduct) {
        productRepository.deleteById(idProduct);
    }
    public Product findProductById(long id) {
        return productRepository.findById(id);
    }
    public void updateProductById(long id, Product product) {
        productRepository.updateById(id, product);
    }

    public void addProduct(Product product) {
        productRepository.add(product);
    }
}
