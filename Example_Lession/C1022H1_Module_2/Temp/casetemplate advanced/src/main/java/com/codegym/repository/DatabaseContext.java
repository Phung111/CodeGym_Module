package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseContext<T> {
    protected List<T> list;
    public DatabaseContext() {
        init();
    }
    public abstract void init();
    public List<T> getAll(){
        return list;
    }

    public List<T> searchByName(ISearch<T> iSearch, String name) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (iSearch.searchByName(list.get(i), name)) {
                result.add(list.get(i));
            }
        }
        return result;
    }
    public  void deleteById(long id){
        for (int i = 0; i < list.size(); i++) {
            IModel<T> iModel = (IModel<T>) list.get(i);
            if (iModel.getId() == id) {
                list.remove(i);
                break;
            }
        }
    }
    public T findById(long id){
        for (int i = 0; i < list.size(); i++) {
            IModel<T> iModel = (IModel<T>) list.get(i);
            if (iModel.getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public void add(T obj){
        list.add(obj);
    }
    public void updateById(long id, T obj){
        for (int i = 0; i < list.size(); i++) {
            IModel<T> iModel = (IModel<T>) list.get(i);
            if (iModel.getId() == id) {
                iModel.update(list.get(i));
            }
        }
    }

}
