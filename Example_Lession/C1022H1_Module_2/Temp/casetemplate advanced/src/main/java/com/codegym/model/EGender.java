package com.codegym.model;

public enum EGender {
    MAlE("Nam", 1),
    FEMALE("Nữ", 2),
    ORTHER("Orther", 3);

    private String value;
    private int id;
    private EGender(String value, int id) {
        this.value = value;
        this.id = id;
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

    public static EGender toEGender(int id) {
        for (EGender e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
