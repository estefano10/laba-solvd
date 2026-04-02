package com.solvd.CarService.model;

import com.solvd.CarService.exception.InvalidCustomerException;

public class ReturningCustomer extends Customer {

    public ReturningCustomer(String name, String lastname, int DNI, boolean regularCostumer) throws InvalidCustomerException {
        super(name, lastname, DNI, regularCostumer);
    }

    @Override
    public double getDiscount(){
        return 0.1;
    }
}
