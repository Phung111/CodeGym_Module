package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.file.CustomerRepository;

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
//        for (int i = 0; i < customers.size(); i++) {
//            if (customers.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
//                return customers.get(i);
//            }
//        }
        return null;
    }
    public void updateCustomerById(long id, Customer customer) {
        customerRepository.updateById(id, customer);
    }

    public void addCustomer(Customer customer) {
        customerRepository.add(customer);
    }
    public void deleteCustomerById(long idCustomer) {
        customerRepository.deleteById(idCustomer);
    }

}
