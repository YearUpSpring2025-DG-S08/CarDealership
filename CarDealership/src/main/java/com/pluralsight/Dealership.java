package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private final DealershipFileManager fileManager = new DealershipFileManager();
    public List<Vehicle> inventory = new ArrayList<>();
    // this variable is currently empty so writing to the file is not working

    // the constructor method of Dealership creates a new ArrayList of type Vehicle
    // which will store the vehicles in the dealership
    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public List<Vehicle> getVehicleByVIN(int vin){
        return null;
    }
    
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }
    
    public List<Vehicle> getVehiclesByMake(String make){
        return null;
    }
    
    public List<Vehicle> getVehicleByModel(String model){
        return null;
    }
    
    public List<Vehicle> getVehiclesByYear(double min, double max){
        return null;
    }
    
    public List<Vehicle> getVehiclesByColor(String color){
        return null;
    }
    
    public List<Vehicle> getVehiclesByMileage(double min, double max){
        return null;
    }
    
    public List<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }
    
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }
    
    public void addVehicle(Vehicle vehicle) {
        //add this vehicle to the inventory of this dealership
        inventory.add(vehicle);
        fileManager.saveDealership(this);
    }
    
    
    public void removeVehicle(Vehicle vehicle){
        // remove this vehicle from the inventory of the dealership
        inventory.remove(vehicle);
        fileManager.saveDealership(this.fileManager.getDealership());
    }
}