package com.codegym.repository.file;

import com.codegym.model.Order;

public class OrderRepository extends FileContext<Order> {
    public OrderRepository() {
        filePath = "./data/order.txt";
        tClass = Order.class;
    }
}
