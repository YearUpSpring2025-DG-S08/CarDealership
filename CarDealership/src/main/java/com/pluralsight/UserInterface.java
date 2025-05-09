package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private Dealership dealership;
    
    public UserInterface(){
    }
    
    // 
    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
        if(this.dealership == null){
            System.out.println("Could not load dealership details");
        }
    }
    
    public void display(){
        init();
        // create a loop and display the menu
        // read user's command
        // code a switch statement that calls the correct process method()
        // could create a helper method to display the menu
    }
    
    private void displayVehicle(List<Vehicle> vehicles){
        // helper method - displays the list and can be called from all the get-vehicles type method
        // this method should have a parameter that is passed in containing the vehicles to list
        // within the method, create a loop and display the vehicles
        for(Vehicle v : vehicles) System.out.println(v);
    }
    
    
    public void processGetByPriceRequest(){
    }
    
    public void processGetMyMakeModelRequest(){
    }
    
    public void processGetByYearRequest(){
    }
    
    public void processGetByColorRequest(){
    }
    
    public void processGetByMileageRequest(){
    }
    
    public void processGetByVehicleTypeRequest(){
    }
    
    public void processGetAllVehiclesRequest(){
        // list all vehicles in the dealership
        // this method will be used to test that we successfully load the dealership and vehicles from the file
        // call the dealership's getAllVehicles() method
        // call the displayVehicles() helper method and pass it the list that is returned from getAllVehicles()
        displayVehicle(dealership.getAllVehicles());
    }
    
    public void processRemoveVehicleRequest(){
    }
    
}
