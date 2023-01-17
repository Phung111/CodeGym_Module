package com.codegym.mycollections;

public interface ICollection<E> {
    void add(E e);
    ICollection<E> getAll();
    E find(int index);
    void update(int index, E e);
}
