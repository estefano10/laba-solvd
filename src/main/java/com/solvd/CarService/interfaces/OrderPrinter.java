package com.solvd.CarService.interfaces;

import com.solvd.CarService.model.Order;

@FunctionalInterface
public interface OrderPrinter {
    void print(Order order);
}
