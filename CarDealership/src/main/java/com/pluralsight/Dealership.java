package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventory;
    
    // the constructor method of Dealership creates a new ArrayList of type Vehicle
    // which will store the vehicles in the dealership
    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
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
    
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }
    
    public List<Vehicle> getVehiclesByMakeModel(String makeModel){
        return null;
    }
    
    public List<Vehicle> getVehiclesByYear(double min, double max){
        return null;
    }
    
    public List<Vehicle> getVehiclesByColor(String color){
        return null;
    }
    
    public List<Vehicle> getVehiclesByMileage(){
        return null;
    }
    
    public List<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }
    
    public List<Vehicle> getAllVehicles(){
        return null;
    }
    
    public void addVehicle(Vehicle vehicle){
        //add this vehicle to the inventory of this dealership.
        inventory.add(vehicle);
    }
    
    public List<Vehicle> removeVehicle(Vehicle vehicle){
        return null;
    }
    
}
