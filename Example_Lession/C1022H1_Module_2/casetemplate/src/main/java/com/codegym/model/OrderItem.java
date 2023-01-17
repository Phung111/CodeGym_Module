package com.codegym.model;

import com.codegym.repository.IModel;

public class OrderItem implements IModel<OrderItem> {

    private long id;
    private long idOrder;
    private long idProduct;
    private int amount;

    public OrderItem(long id, long idOrder, long idProduct, int amount) {
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.amount = amount;
    }
    public OrderItem() {

    }

    public long getId() {
        return id;
    }

    @Override
    public void update(OrderItem objNew) {
        this.idProduct = objNew.getIdProduct();
        this.amount = objNew.getAmount();
        this.idOrder = objNew.getIdOrder();
    }

    @Override
    public OrderItem parseData(String line) {
        //1,1,1672302730,5
        String[] items = line.split(",");
        long idOrderItem = Long.parseLong(items[0]);
        long idOrder = Long.parseLong(items[1]);
        long idProduct = Long.parseLong(items[2]);
        int amount = Integer.parseInt(items[3]);

        OrderItem orderItem = new OrderItem();
        orderItem.setAmount(amount);
        orderItem.setId(idOrderItem);
        orderItem.setIdProduct(idProduct);
        orderItem.setIdOrder(idOrder);
        return orderItem;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
