package com.solvd.CarService.service;

import com.solvd.CarService.interfaces.Calculable;
import com.solvd.CarService.interfaces.Repairable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Repair extends Service implements Repairable, Calculable {
    private int hours;

    private static final Logger LOGGER = LogManager.getLogger(Repair.class);

    public Repair(String serviceName, int hours){
        super(serviceName);
        this.hours = hours;
    }

    @Override
    public void repair(){
        LOGGER.info("Repair in progress...");
    }

    @Override
    public double calculateCost(){
        return hours * 50;
    }

    @Override
    public String toString(){
        return "repaircost: "+calculateCost()+ ", hours: "+hours;
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
