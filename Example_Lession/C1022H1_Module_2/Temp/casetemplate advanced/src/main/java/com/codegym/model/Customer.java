package com.codegym.model;

import com.codegym.repository.IModel;

import java.util.Date;

public class Customer implements IModel<Customer> {
    private long id;
    private String name;
    private int age;
    private String address;
    private Date create;
    private EGender gender;

    public Customer() {
    }

    public Customer(long id, String name, int age, String address, Date create, EGender eGender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.create = create;
        this.gender = eGender;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    @Override
    public void update(Customer objNew) {
        this.gender = objNew.getGender();
        this.age = objNew.getAge();
        this.name = objNew.getName();
        this.create = objNew.getCreate();
        this.address = objNew.getAddress();
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
    public String viewCustomer(){
        return String.format("%5s|%15s|%5s|%10s|%-10s|%-5s", id, name, age, address, create, this.gender.getValue());
    }

    public void updateCustomer(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.age  = customer.getAge();
        this.create = customer.getCreate();
    }
}
