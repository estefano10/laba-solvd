package com.solvd.CarService.model;

import com.solvd.CarService.service.Spare;

public class Toolbox<T> {
    private String brand;
    private T[] items;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }


}
