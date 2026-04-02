package com.solvd.CarService.model;

import com.solvd.CarService.exception.InvalidCustomerException;

public class NewCustomer extends Customer {

    public NewCustomer(String name, String lastname, int DNI, boolean regularCustomer) throws InvalidCustomerException {
        super(name, lastname, DNI, regularCustomer);

    }

    @Override
    public double getDiscount(){
        return 0;
    }
}
