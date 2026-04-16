package com.solvd.CarService.interfaces;

import com.solvd.CarService.model.Car;

@FunctionalInterface
public interface CarValidator {
    boolean validate(Car car);
}
