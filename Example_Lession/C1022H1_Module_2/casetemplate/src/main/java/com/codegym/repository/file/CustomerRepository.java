package com.codegym.repository.file;

import com.codegym.model.Customer;

public class CustomerRepository extends FileContext<Customer>{
    public CustomerRepository() {
        tClass = Customer.class;
        filePath = "./data/customer.txt";
    }


}
