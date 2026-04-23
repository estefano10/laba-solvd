package com.solvd.CarService.model;

public record Invoice(Double totalAmount){
    public Invoice{
        if (totalAmount < 1){
            throw new IllegalArgumentException("Total amount must be grather tan zero");
        }
    }
}
