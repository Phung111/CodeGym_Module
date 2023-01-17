package com.codegym.filereadwrite;

public interface IModel<T> {
    T parseData(String line);
}
