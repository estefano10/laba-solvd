package com.solvd.CarService.model;

public class Car extends Vehicle {
    private String brand;

    public Car(String model, int year, String brand){
        super(model, year);
        this.brand = brand;
    }

    @Override
    public String toString(){
        return "Car model: "+model+", brand: "+brand+ ", year: "+year;
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
}
