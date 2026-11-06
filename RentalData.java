package com.vehiclerental.persistence;

import com.vehiclerental.model.Customer;
import com.vehiclerental.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class RentalData {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    public List<Vehicle> getVehicles() { return vehicles; }
    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }
    public List<Customer> getCustomers() { return customers; }
    public void setCustomers(List<Customer> customers) { this.customers = customers; }
}