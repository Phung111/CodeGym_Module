package com.codegym.model;

public enum EStatusOrder {
    NEW("Mới đặt", 1),
    PAID("Đã thanh toán", 2),
    CANCED("Đã hủy", 3);
    private int id;
    private String value;
    private EStatusOrder(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public static EStatusOrder toEStatusOrder(int id) {
        for (EStatusOrder e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    public static EStatusOrder getEStatusOrderByName(String name) {
        for (EStatusOrder e : values()) {
            if (e.toString().equals(name)) {
                return e;
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
