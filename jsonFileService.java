package com.vehiclerental.persistence;

import com.vehiclerental.collection.RentalCollectionManager;
import com.vehiclerental.model.Bike;
import com.vehiclerental.model.Car;
import com.vehiclerental.model.Vehicle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class jsonFileService {
    public void save(RentalCollectionManager manager, String fileName) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for (Vehicle v : manager.getVehicles()) {
                pw.println(v.getType() + "," + v.getId() + "," + v.getBrand() + "," + v.getRentPrice());
            }
            pw.close();
        } catch (IOException e) { System.out.println("Save Error: " + e.getMessage()); }
    }

    public void load(RentalCollectionManager manager, String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                if (parts[0].equals("Car")) {
                    manager.addVehicle(new Car(parts[1], parts[2], Double.parseDouble(parts[3]), 5));
                } else {
                    manager.addVehicle(new Bike(parts[1], parts[2], Double.parseDouble(parts[3]), true));
                }
            }
            sc.close();
        } catch (Exception e) { System.out.println("Load Error: " + e.getMessage()); }
    }
}