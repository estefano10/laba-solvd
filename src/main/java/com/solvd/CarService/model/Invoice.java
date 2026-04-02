package com.solvd.CarService.model;

public class Invoice {
    private Double totalAmount;

    public Invoice(Double totalAmount){
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
