package com.codegym.repository;

public interface IModel<T> {
    long getId();

    void update(T objNew);

    T parseData(String line);
}
