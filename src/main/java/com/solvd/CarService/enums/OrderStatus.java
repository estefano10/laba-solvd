package com.solvd.CarService.enums;

public enum OrderStatus {
    PENDING("The car repairs have not yet begun"),
    IN_PROGRESS("The car repairs have begun"),
    COMPLETED("The car repairs are complete");

    private final String status;

    OrderStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return "Order Status: " + status;
    }
}
