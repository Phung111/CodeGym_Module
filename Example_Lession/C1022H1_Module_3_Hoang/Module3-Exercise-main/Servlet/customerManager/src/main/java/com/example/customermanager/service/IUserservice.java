package com.example.customermanager.service;

import com.example.customermanager.model.User;

import java.util.List;

public interface IUserservice {
    public boolean checkEmailSignup(String email);

    public List<User> getAllUser();

    public void addCustomer(User user);

    public boolean checkUsernameSignup(String username);

    public boolean checkUserNamePassword(String username, String password);
}
