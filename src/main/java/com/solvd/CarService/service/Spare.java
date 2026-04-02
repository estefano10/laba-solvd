package com.solvd.CarService.service;
import com.solvd.CarService.interfaces.Calculable;
import com.solvd.CarService.exception.OutOfStockException;


public class Spare implements Calculable {
    private String name;
    private int stock;
    private double price;

    public Spare(String name, int stock, double price){
        this.name = name;
        if (stock < 1){
            throw new OutOfStockException("An order cannot be created if spare stock is 0");
        }
        this.stock = stock;
        this.price = price;
    }

    @Override
    public double calculateCost() {
        return price * stock;
    }


    @Override
    public String toString(){
        return "Spare name: "+name+", price: "+price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
