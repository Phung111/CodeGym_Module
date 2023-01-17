package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.file.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;
    public UserService() {
        userRepository = new UserRepository();
    }


    public User checkUserNamePassword(String username, String password) {
        List<User> list = userRepository.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals(username) && list.get(i).getPassword().equals(password)) {
                return list.get(i);
            }
        }
        return null;
    }
}
