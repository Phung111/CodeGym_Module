package com.codegym.view;

import com.codegym.model.User;

import java.util.Scanner;

public abstract class GenericView {
    protected Scanner scanner = new Scanner(System.in);
    protected User user;

    public abstract void launcher();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
