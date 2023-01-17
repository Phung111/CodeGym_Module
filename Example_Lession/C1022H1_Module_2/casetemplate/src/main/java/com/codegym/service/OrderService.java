package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.repository.file.OrderItemRepository;
import com.codegym.repository.file.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private OrderItemService orderItemService;

    public OrderService() {
        orderRepository = new OrderRepository();
        orderItemRepository = new OrderItemRepository();

        orderItemService = new OrderItemService();
    }
    public List<Order> getAllOrders(){
        List<Order> allOrders = orderRepository.getAll();
        for (int i = 0; i < allOrders.size(); i++) {
            List<OrderItem> orderItems = orderItemService.getOrderItemsByIdOrder(allOrders.get(i).getId());
            allOrders.get(i).setOrderItems(orderItems);
        }
        return allOrders;
    }
    public Order findOrderById(long idOrder){
        List<OrderItem> allOrderItems = orderItemRepository.getAll();
        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 0; i < allOrderItems.size(); i++) {
            if (allOrderItems.get(i).getIdOrder() == idOrder) {
                orderItems.add(allOrderItems.get(i));
            }
        }
        Order order = orderRepository.findById(idOrder);
        order.setOrderItems(orderItems);
        return order;
    }
}
