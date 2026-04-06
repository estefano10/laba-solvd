package com.solvd.CarService.model;

import com.solvd.CarService.enums.FuelType;

public class Car extends Vehicle {
    private String brand;
    private final FuelType fuelType;

    public Car(String model, int year, String brand, FuelType fuelType){
        super(model, year);
        this.brand = brand;
        this.fuelType = fuelType;
    }

    @Override
    public String toString(){
        return "Car model: "+model+", brand: "+brand+ ", year: "+year+ ", Fuel type: "+ getFuelType();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Car)) return false;

        Car c = (Car) o;
        return model.equals(c.model);
    }

    @Override
    public int hashCode(){
        return model.hashCode();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
