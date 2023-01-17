package com.codegym.model;

public enum ERole {

    ADMIN("Admin", 1),
    USER("User", 2);
    private String value;
    private int id;
    private ERole(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public static ERole toERole(int id) {
        for (ERole e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    public static ERole getERoleByName(String name) {
        for (ERole e : values()) {
            if (e.toString().equals(name)) {
                return e;
            }
        }
        return null;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
