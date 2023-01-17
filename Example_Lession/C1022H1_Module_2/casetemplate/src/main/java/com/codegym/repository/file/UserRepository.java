package com.codegym.repository.file;

import com.codegym.model.Product;
import com.codegym.model.User;

public class UserRepository extends FileContext<User>{

    public UserRepository() {
        filePath = "./data/user.txt";
        tClass = User.class;
    }
}
