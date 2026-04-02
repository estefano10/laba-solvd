package com.solvd.CarService.model;

import com.solvd.CarService.exception.InvalidCustomerException;
import com.solvd.CarService.interfaces.Discountable;

public abstract class Customer extends Person implements Discountable {
    protected boolean regularCustomer;
    protected int DNI;

    public Customer(String name, String lastname, int DNI, boolean regularCustomer) throws InvalidCustomerException {
        super(name, lastname);
        if (name == null || name.isEmpty() || lastname ==null || lastname.isEmpty()){
            throw new InvalidCustomerException("Name and lastname cannot be null");
        }
        this.regularCustomer = regularCustomer;
        this.DNI = DNI;
    }


    @Override
    public String toString(){
        return "Customer name: "+getName()+", lastname: "+ getLastname() +", DNI: "+ getDNI();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Customer)) return false;

        Customer c = (Customer) o;
        return this.DNI == c.DNI;
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(getDNI());
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public abstract double getDiscount();

}
