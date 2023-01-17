package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.EGender;
import com.codegym.model.Product;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.ISearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService() {
        customerRepository = new CustomerRepository();
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.getAll();
    }
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id);
    }
    public Customer findCustomerByName(String name) {
        List<Customer> customers = customerRepository.getAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return customers.get(i);
            }
        }
        return null;
    }
    public void updateCustomerById(long id, Customer customer) {
        customerRepository.updateById(id, customer);
    }

    public void addCustomer(Customer customer) {
        customerRepository.add(customer);
    }
    public void deleteCustomerById(long idCustomer) {
        deleteCustomerById(idCustomer);
    }

}
