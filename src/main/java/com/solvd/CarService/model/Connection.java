package com.solvd.CarService.model;

public final class Connection {
    private final int id;

    public Connection(int id){
        this.id = id;
    }

    public void open(){
        System.out.println("Opening connection "+ id);
    }

    public void close(){
        System.out.println("Closing connection "+ id);
    }

    @Override
    public String toString() {
        return "Connection-" + id;
    }
}
