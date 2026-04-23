package com.solvd.CarService.model;

import com.solvd.CarService.annotations.Employee;
import com.solvd.CarService.annotations.Sensitive;
import com.solvd.CarService.enums.ExperienceLevel;
import com.solvd.CarService.exception.InvalidHourlyRateException;
import com.solvd.CarService.interfaces.Workable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Employee("mechanic")
public class Mechanic extends Person implements Workable {
    @Sensitive
    private double hourlyRate;
    private final ExperienceLevel experienceLevel;

    private static final Logger LOGGER = LogManager.getLogger(Mechanic.class);

    public Mechanic(String name, String lastname, double hourlyRate, ExperienceLevel experienceLevel)throws InvalidHourlyRateException{
        super(name, lastname);
        if (hourlyRate < 0){
            throw new InvalidHourlyRateException("Hourly rate cannot be negative");
        }
        this.hourlyRate = hourlyRate;
        this.experienceLevel = experienceLevel;
    }


    @Override
    public void work(){
        LOGGER.info("Repairing cars...");
    }

    @Override
    public String toString(){
        return "Mechanic name: "+getName()+", rate: "+hourlyRate+ " Seniority: "+ getExperienceLevel();
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

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }
}
