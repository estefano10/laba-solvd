package com.solvd.CarService.model;

public class Engine {

    private boolean damaged;

    public Engine(boolean damaged){
        this.damaged = damaged;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }
}
