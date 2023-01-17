package com.codegym.model;

import com.codegym.repository.IModel;
import com.codegym.utils.DateUtils;

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
        this.name = objNew.getName();
        this.age = objNew.getAge();
        this.address = objNew.getAddress();
        this.create = objNew.getCreate();
    }

    @Override
    public Customer parseData(String line) {
        String[] items = line.split(",");
        //1,Quang Dang,23,28 Nguyen Tri Phuong,2022-12-20 08:30:45,MAlE
        long idCustomer = Long.parseLong(items[0]);
        int age = Integer.parseInt(items[2]);
        Date createAt = DateUtils.parseDate(items[4]);
        EGender eGender = EGender.getEGenderByName(items[5]);

        //long id, String name, int age, String address, Date create, EGender eGender) {
        Customer customer = new Customer(idCustomer, items[1], age, items[3], createAt, eGender);
        return customer;
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


    @Override
    public String toString() {
        //1,Quang Dang,23,28 Nguyen Tri Phuong,2022-12-20 08:30:45,MAlE
        String strDate = DateUtils.convertDateToString(this.create);
        return String.format("%s,%s,%s,%s,%s,%s", this.id,this.name, this.age,this.address,strDate,gender);
    }
}
