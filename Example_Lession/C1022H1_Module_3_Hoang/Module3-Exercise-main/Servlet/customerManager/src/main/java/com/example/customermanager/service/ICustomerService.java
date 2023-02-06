package com.example.customermanager.service;

import com.example.customermanager.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();

    List<Customer> getAllCustomersByKwAndIdCountry(String kw, long idCountry);
    List<Customer> getAllCustomersByKwAndIdCountryPagging(String kw, long idCountry, int page, int numberOfPage);
    void addCustomer(Customer customer);
    Customer findCustomerById(long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(long id);

    public long findCustomerByIdMax();

    List<Customer> getAllCustomerByIdCountry(long idCountry);

    int getNoOfRecords();
}
