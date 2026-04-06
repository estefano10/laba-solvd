package com.solvd.CarService.enums;

public enum ExperienceLevel {
    JUNIOR("Example description", 2),
    SEMI_SENIOR("Example description", 5),
    SENIOR("Example description", 9);

    private final String description;
    private final int yearsOfExperience;

     ExperienceLevel(String description, int yearsOfExperience){
        this.description = description;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDescription() {
        return description;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
