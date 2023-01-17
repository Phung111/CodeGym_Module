package com.codegym.service;

import com.codegym.model.OrderItem;
import com.codegym.repository.file.OrderItemRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService {
    private OrderItemRepository orderItemRepository;

    public OrderItemService() {
        orderItemRepository = new OrderItemRepository();
    }
    public List<OrderItem> getOrderItemsByIdOrder(long idOrder) {
        List<OrderItem> allOrderItems = orderItemRepository.getAll();

        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 0; i < allOrderItems.size(); i++) {
            if (allOrderItems.get(i).getIdOrder() == idOrder) {
                orderItems.add(allOrderItems.get(i));
            }
        }
        return orderItems;
    }
}
