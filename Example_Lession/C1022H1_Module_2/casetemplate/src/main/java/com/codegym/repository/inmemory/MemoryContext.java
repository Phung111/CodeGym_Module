package com.codegym.repository.inmemory;

import com.codegym.repository.IModel;

import java.util.List;

public abstract class MemoryContext<T> {
    protected List<T> list;
    public MemoryContext() {
        init();
    }

    public abstract void init();
    public List<T> getAll(){
        return list;
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
                iModel.update(obj);
            }
        }
    }

}
