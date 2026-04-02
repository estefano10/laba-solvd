package com.solvd.CarService.model;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> items = new ArrayList<>();
    public void add(T item){
        items.add(item);
    }
    public T get(int index){
        return items.get(index);
    }
    public List<T> getAll() {
        return items;
    }
}
