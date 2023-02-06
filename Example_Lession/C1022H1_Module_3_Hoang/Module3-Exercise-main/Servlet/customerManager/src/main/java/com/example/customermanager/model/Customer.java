package com.example.customermanager.model;

public class Customer {
    private long id;
    private String name;
    private String address;
    private long idCountry;
    private String picture;

    public Customer() {
    }

    public Customer(long id, String name, String address, long idCountry, String picture) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idCountry = idCountry;
        this.picture = picture;
    }

    public long getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
