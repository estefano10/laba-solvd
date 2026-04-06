package com.solvd.CarService.enums;

public enum FuelType {
    GASOLINE("gasoline"),
    DIESEL("diesel"),
    ELECTRIC("electricity"),
    HYBRID("gasoline/diesel and electricity") ;

    private final String type;

    FuelType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
