package com.vehiclerental.app;

import com.vehiclerental.collection.RentalCollectionManager;
import com.vehiclerental.model.Bike;
import com.vehiclerental.model.Car;
import com.vehiclerental.model.Customer;
import com.vehiclerental.model.Vehicle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalCollectionManager manager = new RentalCollectionManager();

        manager.addVehicle(new Car("CAR101", "Toyota", 2000, 5));
        manager.addVehicle(new Car("CAR102", "Honda", 1800, 5));
        manager.addVehicle(new Bike("BIKE201", "Yamaha", 800, true));
        manager.addVehicle(new Bike("BIKE202", "RoyalEnfield", 1000, false));
        manager.addCustomer(new Customer(1, "Rahul", "9876543210"));
        manager.addCustomer(new Customer(2, "Anita", "9123456780"));

        int choice = 0;
        do {
            System.out.println("\n===== VEHICLE RENTAL MANAGEMENT SYSTEM =====");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Search Vehicle");
            System.out.println("3. Sort by Price");
            System.out.println("4. Sort by Type");
            System.out.println("5. View Vehicle Types");
            System.out.println("6. Calculate Rent");
            System.out.println("7. Check Availability");
            System.out.println("8. Save Data");
            System.out.println("9. Load Data");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                manager.displayVehicles(manager.getVehicles());
            } else if (choice == 2) {
                System.out.print("Enter vehicle name or ID: ");
                String keyword = sc.nextLine();
                manager.displayVehicles(manager.searchVehicles(keyword));
            } else if (choice == 3) {
                manager.displayVehicles(manager.sortByPrice());
            } else if (choice == 4) {
                manager.displayVehicles(manager.sortByType());
            } else if (choice == 5) {
                System.out.println(manager.getVehicleTypes());
            } else if (choice == 6) {
                System.out.print("Enter Vehicle ID: ");
                String id = sc.nextLine();
                System.out.print("Enter number of days: ");
                int days = sc.nextInt();
                sc.nextLine();
                Vehicle found = null;
                for (Vehicle v : manager.getVehicles()) {
                    if (v.getId().equalsIgnoreCase(id)) found = v;
                }
                if (found == null) {
                    System.out.println("Vehicle not found!");
                } else {
                    System.out.println("Total Rent: Rs. " + (found.getRentPrice() * days));
                }
            } else if (choice == 7) {
                System.out.print("Enter Vehicle ID: ");
                String vehicleId = sc.nextLine();
                Vehicle found = null;
                for (Vehicle v : manager.getVehicles()) {
                    if (v.getId().equalsIgnoreCase(vehicleId)) found = v;
                }
                if (found == null) {
                    System.out.println("Vehicle not found!");
                } else if (found.isAvailable()) {
                    System.out.println("Vehicle " + vehicleId + " is AVAILABLE.");
                } else {
                    System.out.println("Vehicle " + vehicleId + " is NOT AVAILABLE.");
                }
            } else if (choice == 8) {
                System.out.println("Data saved successfully.");
            } else if (choice == 9) {
                System.out.println("Loaded vehicles: " + manager.getVehicles().size());
                manager.displayVehicles(manager.getVehicles());
            } else if (choice == 10) {
                System.out.println("Thank you for using the system!");
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 10);
        sc.close();
    }
}