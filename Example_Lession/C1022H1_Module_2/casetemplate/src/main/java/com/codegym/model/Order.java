package com.codegym.model;

import com.codegym.repository.IModel;
import com.codegym.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Order implements IModel<Order> {
    private long id;
    private String nameCustomer;
    private double total;
    private Date createAt;
    private EStatusOrder eStatusOrder;

    private List<OrderItem> orderItems;

    public long getId() {
        return id;
    }

    @Override
    public void update(Order objNew) {
        this.nameCustomer = objNew.getNameCustomer();
        this.createAt = objNew.getCreateAt();
        this.total = objNew.getTotal();
        this.orderItems = objNew.getOrderItems();
        this.eStatusOrder = objNew.geteStatusOrder();
    }

    @Override
    public Order parseData(String line) {
        // line: 1,Quang Dang,100000,2022-12-20 08:30:45,NEW
        String[] items = line.split(",");
        Order order = new Order();
        long idOrder = Long.parseLong(items[0]);
        double total = Double.parseDouble(items[2]);
        Date createAt = DateUtils.parseDate(items[3]);
        EStatusOrder statusOrder = EStatusOrder.getEStatusOrderByName(items[4]);

        order.setId(idOrder);
        order.setNameCustomer(items[1]);
        order.setTotal(total);
        order.setCreateAt(createAt);
        order.seteStatusOrder(statusOrder);
        return order;
    }

    public EStatusOrder geteStatusOrder() {
        return eStatusOrder;
    }

    public void seteStatusOrder(EStatusOrder eStatusOrder) {
        this.eStatusOrder = eStatusOrder;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order() {

    }
    public Order(long id, String nameCustomer, double total, Date createAt, List<OrderItem> orderItems) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.total = total;
        this.createAt = createAt;
        this.orderItems = orderItems;
    }
    public Order(long id, String nameCustomer, double total, Date createAt, EStatusOrder eStatusOrder) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.total = total;
        this.createAt = createAt;
        this.orderItems = orderItems;
        this.eStatusOrder = eStatusOrder;
    }
}
