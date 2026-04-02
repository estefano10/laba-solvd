package com.solvd.CarService.model;

public abstract class Vehicle {
    protected String model;
    protected int year;

    public Vehicle(String model, int year){
        this.model = model;
        this.year = year;
    }
}
