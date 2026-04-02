package com.solvd.CarService.model;

public class Ecu {
    private String moduleType;
    public String firmwareVersion;
    public String OS;

    public Ecu(String moduleType, String firmwareVersion, String OS){
        this.moduleType = moduleType;
        this.firmwareVersion = firmwareVersion;
        this.OS = OS;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }
}
