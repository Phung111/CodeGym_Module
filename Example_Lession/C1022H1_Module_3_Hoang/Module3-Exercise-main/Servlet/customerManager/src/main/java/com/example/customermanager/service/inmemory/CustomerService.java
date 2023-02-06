package com.example.customermanager.service.inmemory;

import com.example.customermanager.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public  CustomerService() {
        customers = new ArrayList<>();
        customers.add(new Customer( 1l, "Nhat Hoang", "112 NTP", 1, "https://vnn-imgs-a1.vgcloud.vn/icdn.dantri.com.vn/2021/05/26/ngo-ngang-voi-ve-dep-cua-hot-girl-anh-the-chua-tron-18-docx-1622043349706.jpeg"));
        customers.add(new Customer( 2l, "Nhat Hoang", "112 NTP", 1, "https://anh.24h.com.vn/upload/4-2017/images/2017-12-02/zc-gai-xinh-tren-mang-1-1512201912-526-width600height600.jpg"));
        customers.add(new Customer(3l, "Nhat Hoang", "112 NTP", 2, "https://image.thanhnien.vn/w1024/Uploaded/2022/zsfe/2022_11_03/img-3846-1-1860.jpg"));
        customers.add(new Customer(4l, "Nhat Hoang", "112 NTP", 2, "https://image.phunuonline.com.vn/fckeditor/upload/2020/20200308/images/gai-dep-kho-lay-chong-_1583686997.jpg"));
        customers.add(new Customer( 5l, "Nhat Hoang", "112 NTP", 3, "https://i.pinimg.com/236x/85/db/c7/85dbc7db3433bae053dfd4a9c7685ab9.jpg"));
    }

    public List<Customer> getAllCustomers() {
        return this.customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerById(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setAddress(customer.getAddress());
                c.setIdCountry(customer.getIdCountry());
                c.setPicture(customer.getPicture());
            }
        }
    }

    public  void deleteCustomer(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                return;
            }
        }
    }
}
