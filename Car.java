package com.vehiclerental.model;

public class Car extends Vehicle {
    private int seats;
    public Car(String id, String brand, double rentPrice, int seats) {
        super(id, brand, rentPrice);
        this.seats = seats;
    }
    public int getSeats() { return seats; }
    @Override
    public String getType() { return "Car"; }
    @Override
    public String toString() {
        return super.toString() + " | Seats: " + seats;
    }
}