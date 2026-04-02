package com.solvd.CarService.model;

public class Tool {
    private String name;

    public Tool(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Tool name: "+ name;
    }
}
