package com.vehiclerental.model;

public class Bike extends Vehicle {
    private boolean hasHelmet;
    public Bike(String id, String brand, double rentPrice, boolean hasHelmet) {
        super(id, brand, rentPrice);
        this.hasHelmet = hasHelmet;
    }
    @Override
    public String getType() { return "Bike"; }
    @Override
    public String toString() {
        return super.toString() + " | Helmet: " + hasHelmet;
    }
}