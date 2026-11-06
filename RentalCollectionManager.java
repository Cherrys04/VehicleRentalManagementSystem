package com.vehiclerental.collection;

import com.vehiclerental.model.Customer;
import com.vehiclerental.model.Vehicle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RentalCollectionManager {
    private GenericRepository<Vehicle> vehicleRepo = new GenericRepository<>();
    private GenericRepository<Customer> customerRepo = new GenericRepository<>();

    public void addVehicle(Vehicle v) { vehicleRepo.add(v); }
    public void addCustomer(Customer c) { customerRepo.add(c); }
    public List<Vehicle> getVehicles() { return vehicleRepo.getAll(); }
    public List<Customer> getCustomers() { return customerRepo.getAll(); }

    public void displayVehicles(List<Vehicle> list) {
        if (list.isEmpty()) { System.out.println("No vehicles found!"); return; }
        for (Vehicle v : list) { System.out.println(v); }
    }
    public List<Vehicle> searchVehicles(String keyword) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : getVehicles()) {
            if (v.getId().equalsIgnoreCase(keyword) || v.getBrand().equalsIgnoreCase(keyword)) result.add(v);
        }
        return result;
    }
    public List<Vehicle> sortByPrice() {
        List<Vehicle> sorted = new ArrayList<>(getVehicles());
        sorted.sort(Comparator.comparingDouble(Vehicle::getRentPrice));
        return sorted;
    }
    public List<Vehicle> sortByType() {
        List<Vehicle> sorted = new ArrayList<>(getVehicles());
        sorted.sort(Comparator.comparing(Vehicle::getType));
        return sorted;
    }
    public Set<String> getVehicleTypes() {
        Set<String> types = new HashSet<>();
        for (Vehicle v : getVehicles()) types.add(v.getType());
        return types;
    }
}