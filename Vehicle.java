package com.vehiclerental.model;

public abstract class Vehicle {
    protected String id;
    protected String brand;
    protected double rentPrice;
    protected boolean available;

    public Vehicle(String id, String brand, double rentPrice) {
        this.id = id;
        this.brand = brand;
        this.rentPrice = rentPrice;
        this.available = true;
    }
    public String getId() { return id; }
    public String getBrand() { return brand; }
    public double getRentPrice() { return rentPrice; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " | ID: " + id + " | Brand: " + brand + " | Price: Rs." + rentPrice + " | Available: " + available;
    }
}