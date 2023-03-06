package com.example.case4.service;

import com.example.case4.model.Customer;

import java.util.List;

//public interface ICustomerService {
//
//    List<Customer> findAll();
//
//    void save(Customer customer);
//
//    Customer findById(long id);
//
//    void update(long id, Customer customer);
//
//    void remove(long id);
//}

public interface ICustomerService extends IGeneratedService<Customer> {
    List<Customer> findEmailByEmail(String email);
}
