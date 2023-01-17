package com.codegym.model;

import com.codegym.repository.IModel;

public class User implements IModel<User> {
    private long id;
    private String name;
    private String email;
    private String password;
    private ERole role;

    public User() {

    }

    public User(long id, String name, String email, String password, ERole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    @Override
    public void update(User objNew) {
        //
    }

    @Override
    public User parseData(String line) {
        // 1672302726,Quang Dang,quangdang@gmail.com,123123,1
        String[] items = line.split(",");
        long id = Long.parseLong(items[0]);
        ERole eRole = ERole.toERole(Integer.parseInt(items[4]));
        User user = new User();
        user.setEmail(items[2]);
        user.setPassword(items[3]);
        user.setName(items[1]);
        user.setRole(eRole);
        user.setId(id);
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
