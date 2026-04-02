package com.solvd.CarService.service;

import com.solvd.CarService.interfaces.Calculable;

public abstract class Service implements Calculable {
    protected String serviceName;

    public Service(String serviceName){
        this.serviceName = serviceName;
    }

    public abstract double calculateCost();

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
