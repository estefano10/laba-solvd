package com.solvd.CarService.model;

import com.solvd.CarService.enums.OrderStatus;
import com.solvd.CarService.interfaces.Printable;
import com.solvd.CarService.service.Repair;
import com.solvd.CarService.service.Spare;

import java.util.HashMap;
import java.util.Map;

public class Order implements Printable {
    private Customer customer;
    private Car car;
    private Mechanic mechanic;
    private Repair repair;
    private Spare spare;
    private OrderStatus orderStatus;

    public Order(Customer customer, Car car, Mechanic mechanic, Repair repair, Spare spare, OrderStatus orderStatus){
        this.customer = customer;
        this.car = car;
        this.mechanic = mechanic;
        this.repair = repair;
        this.spare = spare;
        this.orderStatus = orderStatus;
    }

    @Override
    public String printDetails(){
        return "Order total: "+ calculateTotal();
    }

    public double calculateTotal(){
        double laborCost = mechanic.getHourlyRate() * repair.getHours();
        double spareCost = spare.getPrice();
        double surcharge = 50;
        double total = laborCost + spareCost + surcharge;

        return total - (total * customer.getDiscount());
    }

    public Map<String, Double> getCostBreakdown(){
        Map<String, Double> cost = new HashMap<>();
        cost.put("Labor cost", mechanic.getHourlyRate() * repair.getHours());
        cost.put("Spare cost", spare.getPrice());
        cost.put("Surcharge", 50.0);
        return cost;
    }

    public String toString(){
        return "Order:\n" +
                customer + "\n" +
                car + "\n" +
                mechanic + "\n" +
                repair + "\n" +
                spare + "\n" +
                orderStatus + "\n" +
                "Total: " + calculateTotal();
    }
}
