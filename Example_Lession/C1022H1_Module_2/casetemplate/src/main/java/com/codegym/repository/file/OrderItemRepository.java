package com.codegym.repository.file;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;

public class OrderItemRepository extends FileContext<OrderItem>{
    public OrderItemRepository() {
        filePath = "./data/order_item.txt";
        tClass = OrderItem.class;
    }
}
