package com.codegym.filereadwrite;

import java.util.Objects;

public class Product implements IModel<Product> {
    protected String name;
    private long id;
    private double price;


    public Product(long id,String name,  double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Product(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        //1,Iphone 11,23000
        return String.format("%s,%s,%s", this.id, this.name, this.price);
    }

    @Override
    public Product parseData(String line) {
        String [] items = line.split(",");
        long idProduct = Long.parseLong(items[0]);
        String name = items[1];
        double price = Double.parseDouble(items[2]);
        Product p = new Product(idProduct, name, price);

        return p;
    }
}
