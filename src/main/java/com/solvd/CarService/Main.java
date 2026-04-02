package com.solvd.CarService;

import com.solvd.CarService.exception.InvalidCustomerException;
import com.solvd.CarService.exception.InvalidHourlyRateException;
import com.solvd.CarService.exception.OutOfStockException;
import com.solvd.CarService.interfaces.Calculable;
import com.solvd.CarService.model.*;
import com.solvd.CarService.service.Repair;
import com.solvd.CarService.service.Spare;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class Main {
    static {
        System.setProperty("log4j.configurationFile", "./src/main/resources/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        // Testing INTERFACE: Calculable
        Calculable repairService = new Repair("Repair", 10);
        LOGGER.info("Repair cost: " + repairService.calculateCost());

        Calculable spareService = new Spare("ECU", 7, 1000);
        LOGGER.info("Spare cost: " + spareService.calculateCost());

        // Testing COLLECTION: HashSet - no duplicate customers allowed
        Set<Customer> customers = new HashSet<>();
        try {
            customers.add(new ReturningCustomer("Estefano", "Gigena", 40662596, true));
            customers.add(new ReturningCustomer("Estefano", "Gigena", 40662597, true));
        } catch (InvalidCustomerException e) {
            LOGGER.error(e.getMessage());
        }
        for (Customer c : customers) {
            LOGGER.info("Discount: " + c.getDiscount());
        }

        Car car = new Car("325I", 2026, "BMW");

        // Testing COLLECTION: ArrayList - list of mechanics
        List<Mechanic> mechanics = new ArrayList<>();
        try {
            mechanics.add(new Mechanic("Allen", "Smith", 300));
            mechanics.add(new Mechanic("John", "Doe", 100));
        } catch (InvalidHourlyRateException e) {
            LOGGER.error(e.getMessage());
        }

        Repair repair = new Repair("Repair", 10);

        // Testing COLLECTION: LinkedList - list of spares
        List<Spare> spares = new LinkedList<>();
        try {
            spares.add(new Spare("ECU", 3, 1000));
            spares.add(new Spare("Wheel", 20, 500));
        } catch (OutOfStockException e) {
            LOGGER.error(e.getMessage());
        }

        // Testing ORDER and EXCEPTION: InvalidCustomerException, InvalidHourlyRateException, OutOfStockException
        Order order = new Order(customers.iterator().next(), car, mechanics.get(0), repair, spares.get(1));
        LOGGER.info(order.toString());

        // Testing COLLECTION: HashMap - cost breakdown of an order
        Map<String, Double> costBreakdown = order.getCostBreakdown();
        costBreakdown.entrySet().forEach(entry -> LOGGER.info(entry.getKey() + ": " + entry.getValue()));

        // Testing COLLECTION: LinkedHashSet - allowed car brands (no duplicates, insertion order maintained)
        LinkedHashSet<String> allowedCarBrands = new LinkedHashSet<>();
        allowedCarBrands.add("BMW");
        allowedCarBrands.add("BMW");
        allowedCarBrands.add("Audi");
        allowedCarBrands.add("Ferrari");
        allowedCarBrands.add("Ferrari");
        allowedCarBrands.add("Bugatti");
        for (String brand : allowedCarBrands) {
            LOGGER.info(brand);
        }

        // Testing GENERIC CLASS: Toolbox<Spare>
        Spare spare1 = new Spare("LED", 4, 10.0);
        Spare spare2 = new Spare("Button", 2, 5.0);
        Spare[] sparesList = {spare1, spare2};
        Toolbox<Spare> toolbox = new Toolbox<>();
        toolbox.setItems(sparesList);
        for (Spare item : toolbox.getItems()) {
            LOGGER.info(item.toString());
        }

        // Testing GENERIC CLASS: Toolbox<Tool>
        Tool tool1 = new Tool("Wrench");
        Tool tool2 = new Tool("Jack");
        Tool[] toolsList = {tool1, tool2};
        Toolbox<Tool> toolbox2 = new Toolbox<>();
        toolbox2.setItems(toolsList);
        for (Tool item : toolbox2.getItems()) {
            LOGGER.info(item.toString());
        }

        // Testing GENERIC CLASS: Repository<Mechanic>
        Repository<Mechanic> mechanicsGenericList = new Repository<>();
        try {
            mechanicsGenericList.add(new Mechanic("Lionel", "Messi", 10.0));
            mechanicsGenericList.add(new Mechanic("Enzo", "Ferrari", 9.0));
        } catch (InvalidHourlyRateException e) {
            LOGGER.error(e.getMessage());
        }
        for (Mechanic m : mechanicsGenericList.getAll()) {
            LOGGER.info(m.toString());
        }

        // Testing GENERIC CLASS: Pair<Mechanic, Order>
        Pair<Mechanic, Order> assignment = new Pair<>(mechanics.get(0), order);
        LOGGER.info(assignment.getFirst().toString());
        LOGGER.info(assignment.getSecond().toString());
    }
}