package com.solvd.CarService.model;

import com.solvd.CarService.exception.InvalidHourlyRateException;
import com.solvd.CarService.interfaces.Workable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Mechanic extends Person implements Workable {
    private double hourlyRate;

    private static final Logger LOGGER = LogManager.getLogger(Mechanic.class);

    public Mechanic(String name, String lastname, double hourlyRate)throws InvalidHourlyRateException{
        super(name, lastname);
        if (hourlyRate < 0){
            throw new InvalidHourlyRateException("Hourly rate cannot be negative");
        }
        this.hourlyRate = hourlyRate;
    }


    @Override
    public void work(){
        LOGGER.info("Repairing cars...");
    }

    @Override
    public String toString(){
        return "Mechanic name: "+getName()+", rate: "+hourlyRate;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;

        Mechanic m = (Mechanic) o;
        return getName().equals(m.getName()) &&
                getLastname().equals(m.getLastname());
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(getName(), getLastname());
    }



    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
