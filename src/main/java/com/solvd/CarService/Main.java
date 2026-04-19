package com.solvd.CarService;

import com.solvd.CarService.annotations.Employee;
import com.solvd.CarService.annotations.Sensitive;
import com.solvd.CarService.enums.ExperienceLevel;
import com.solvd.CarService.enums.FuelType;
import com.solvd.CarService.enums.OrderStatus;
import com.solvd.CarService.exception.InvalidCustomerException;
import com.solvd.CarService.exception.InvalidHourlyRateException;
import com.solvd.CarService.exception.OutOfStockException;
import com.solvd.CarService.interfaces.Calculable;
import com.solvd.CarService.interfaces.CarValidator;
import com.solvd.CarService.interfaces.MechanicValidator;
import com.solvd.CarService.interfaces.OrderPrinter;
import com.solvd.CarService.model.*;
import com.solvd.CarService.service.Repair;
import com.solvd.CarService.service.Spare;

import com.solvd.CarService.utils.SensitiveMasker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
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
        //Testing STREAMS
        Set<Customer> customers = new HashSet<>();
        try {
            customers.add(new ReturningCustomer("Estefano", "Gigena", 40662596, true));
            customers.add(new ReturningCustomer("Estefano", "Gigena", 40662597, true));
        } catch (InvalidCustomerException e) {
            LOGGER.error(e.getMessage());
        }
        customers.stream()
                .forEach(c -> LOGGER.info("Discount: " + c.getDiscount()));


        Car car = new Car("325I", 2026, "BMW", FuelType.GASOLINE );

        // Testing COLLECTION: ArrayList - list of mechanics
        List<Mechanic> mechanics = new ArrayList<>();
        try {
            mechanics.add(new Mechanic("Allen", "Smith", 500, ExperienceLevel.SENIOR));
            mechanics.add(new Mechanic("John", "Doe", 100, ExperienceLevel.JUNIOR));
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
        Order order = new Order(customers.iterator().next(), car, mechanics.get(0), repair, spares.get(1), OrderStatus.PENDING);
        LOGGER.info(order.toString());

        // Testing COLLECTION: HashMap - cost breakdown of an order
        Map<String, Double> costBreakdown = order.getCostBreakdown();
        costBreakdown.entrySet().forEach(entry -> LOGGER.info(entry.getKey() + ": " + entry.getValue()));

        // Testing COLLECTION: LinkedHashSet - allowed car brands (no duplicates, insertion order maintained)
        //Testing STREAMS
        LinkedHashSet<String> allowedCarBrands = new LinkedHashSet<>();
        allowedCarBrands.add("BMW");
        allowedCarBrands.add("BMW");
        allowedCarBrands.add("Audi");
        allowedCarBrands.add("Ferrari");
        allowedCarBrands.add("Ferrari");
        allowedCarBrands.add("Bugatti");
        allowedCarBrands.stream()
                .forEach(brand -> LOGGER.info(brand));


        // Testing GENERIC CLASS: Toolbox<Spare>
        //Testing STREAMS
        Spare spare1 = new Spare("LED", 4, 10.0);
        Spare spare2 = new Spare("Button", 2, 5.0);
        Spare[] sparesList = {spare1, spare2};
        Toolbox<Spare> toolbox = new Toolbox<>();
        toolbox.setItems(sparesList);
        Arrays.stream(sparesList)
                .forEach(item -> LOGGER.info(item.toString()));


        // Testing GENERIC CLASS: Toolbox<Tool>
        Tool tool1 = new Tool("Wrench");
        Tool tool2 = new Tool("Jack");
        Tool[] toolsList = {tool1, tool2};
        Toolbox<Tool> toolbox2 = new Toolbox<>();
        toolbox2.setItems(toolsList);
        Arrays.stream(toolsList)
                        .forEach(item ->LOGGER.info(item.toString()));


        // Testing GENERIC CLASS: Repository<Mechanic>
        //Testing STREAMS
        Repository<Mechanic> mechanicsGenericList = new Repository<>();
        try {
            mechanicsGenericList.add(new Mechanic("Lionel", "Messi", 10.0, ExperienceLevel.JUNIOR));
            mechanicsGenericList.add(new Mechanic("Enzo", "Ferrari", 19.0, ExperienceLevel.SEMI_SENIOR));
        } catch (InvalidHourlyRateException e) {
            LOGGER.error(e.getMessage());
        }
        mechanicsGenericList.getAll().stream()
                .forEach(m -> LOGGER.info(m.toString()));


        // Testing GENERIC CLASS: Pair<Mechanic, Order>
        Pair<Mechanic, Order> assignment = new Pair<>(mechanics.get(0), order);
        LOGGER.info(assignment.first().toString());
        LOGGER.info(assignment.second().toString());

        //Testing ENUMS: ExperienceLevel
        List<Mechanic> mechanicsEnum = new ArrayList<>();
        try {
            mechanicsEnum.add(new Mechanic("Will", "Smith", 500, ExperienceLevel.SENIOR));
            mechanicsEnum.add(new Mechanic("Mark", "Doe", 100, ExperienceLevel.JUNIOR));
        } catch (InvalidHourlyRateException e) {
            LOGGER.error(e.getMessage());
        }
        Order order2 = new Order(customers.iterator().next(), car, mechanicsEnum.get(1), repair, spares.get(1), OrderStatus.IN_PROGRESS);
        LOGGER.info(order2.toString());

        //Testing ENUMS: FuelType
        Car car2 = new Car("325I", 2026, "BMW", FuelType.GASOLINE );
        System.out.println("car2 = " + car2);

        //Testing ENUMS: OrderStatus
        Order order3 = new Order(customers.iterator().next(), car, mechanicsEnum.get(1), repair, spares.get(1), OrderStatus.COMPLETED);
        LOGGER.info(order3.toString());

        //Testing LAMBDA: MechanicValidator
        MechanicValidator isSenior = mechanic -> mechanic.getExperienceLevel() == ExperienceLevel.SENIOR;
        LOGGER.info("Is mechanic Senior? "+ isSenior.validate(mechanics.get(0)));

        //Testing LAMBDA: CarValidator
        CarValidator isEcoFriendly = car3 -> car.getFuelType() == FuelType.ELECTRIC;
        LOGGER.info("Is car eco frindly? "+ isEcoFriendly.validate(car2));

        //Testing LAMBDA: OrderPrinter
        OrderPrinter printer = currentOrder -> LOGGER.info(order.toString());
        printer.print(order);

        //Testing RECORDS
        Pair<String, Integer> pairRecord = new Pair<>("Estefano", 28);
        LOGGER.info(pairRecord.first());
        LOGGER.info(pairRecord.second());

        Ecu ecuRecord = new Ecu("Bosch EDC17C46","SW: 1037505841","OSEK/VDX");
        LOGGER.info(ecuRecord.moduleType());
        LOGGER.info(ecuRecord.firmwareVersion());
        LOGGER.info(ecuRecord.OS());

        Invoice invoiceRecord = new Invoice(1000.0);
        LOGGER.info(invoiceRecord.totalAmount());

        //Testing ANNOTATIONS
        try {
            Mechanic myMechanic = new Mechanic("Declan", "Rice", 500.0, ExperienceLevel.SEMI_SENIOR);
            var anotacion = myMechanic.getClass().getAnnotations();
            System.out.println(Arrays.toString(anotacion));
            System.out.println("TESTING SENSITIVEMASKER");
            SensitiveMasker.mask(myMechanic);

            if (myMechanic.getClass().isAnnotationPresent(Employee.class)){
                System.out.println("This is an employee");
            }else {
                System.out.println("Is not a employee");
            }

        }catch (InvalidHourlyRateException e){
            LOGGER.error(e.getMessage());
        }

        try {
            NewCustomer myCustomer = new NewCustomer("Luis", "Diaz", 40662597, false);
            for (Field field : myCustomer.getClass().getSuperclass().getDeclaredFields()){
                if (field.isAnnotationPresent(Sensitive.class)){
                    System.out.println("Sensitive field found: " + field.getName());
                }
            }
        }catch (InvalidCustomerException e){
            LOGGER.error(e.getMessage());
        }

        //BONUS
        try {
            NewCustomer myCustomer2 = new NewCustomer("Jose", "Diaz", 40662851, true);
            List<FieldResult> results = SensitiveMasker.mask(myCustomer2);
            results.forEach(r -> LOGGER.info(r.fieldName()+": "+ r.value()));
        }catch (InvalidCustomerException e){
            LOGGER.error(e.getMessage());
        }



    }
}