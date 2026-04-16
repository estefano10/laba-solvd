package com.solvd.CarService.interfaces;

import com.solvd.CarService.model.Mechanic;

@FunctionalInterface
public interface MechanicValidator {
    boolean validate(Mechanic mechanic);
}
