package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.EGender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository extends DatabaseContext<Customer> {
    public CustomerRepository() {
    }
    @Override
    public void init() {
        list = new ArrayList<>();
        list.add(new Customer(456, "John", 20, "Huế", new Date(), EGender.MAlE));
        list.add(new Customer(457, "Levis", 30, "Huế", new Date(), EGender.MAlE));
        list.add(new Customer(458, "Tom", 25, "ĐN", new Date(), EGender.FEMALE));
    }
}
