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
        return "Car model: "+getModel()+", brand: "+brand+ ", year: "+getYear()+ ", Fuel type: "+ getFuelType();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Car)) return false;

        Car c = (Car) o;
        return getModel().equals(c.getModel());
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int hashCode(){
        return getModel().hashCode();
    }


    public FuelType getFuelType() {
        return fuelType;
    }
}
