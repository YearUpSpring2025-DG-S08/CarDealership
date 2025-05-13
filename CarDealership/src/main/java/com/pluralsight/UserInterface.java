package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    public DealershipFileManager fileManager = new DealershipFileManager();
    private Console console;
    private Scanner scanner;

    public UserInterface() {
    }

    // this method initializes the Dealership object to be accessed by the User
    private void init() {
        this.dealership = fileManager.getDealership();
        if (this.dealership == null) {
            System.out.println("Could not load dealership details");
        }
    }

    public void display() {
        init();
        // create a loop and display the menu
        // read user's command
        // code a switch statement that calls the correct process method()
        // could create a helper method to display the menu
        displayMenu();
    }

    public void displayMenu() {
        // this helper method will display the menu for the User to make a selection
        // for which process they would like to choose
        // will include accepting user input within this method
        int input = -1;
        while(input != -1) {
            String welcomeMenuPrompt = """
                    Welcome to D's Car Dealership!
                    Please select a search criteria:
                    [1] Search by Price
                    [2] Search by Make/Model
                    [3] Search by Year
                    [4] Search by Color
                    [5] Search by Mileage
                    [6] Search by Vehicle Type
                    [7] Search All Vehicles
                    [8] Remove Vehicle from lot""";

            input = console.promptForInt(welcomeMenuPrompt);

            switch (input) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetMyMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processRemoveVehicleRequest();
                    break;
                default:
                    System.out.println("Please mke a selection from the menu");
            }
        }
    }

    private void displayVehicle(List<Vehicle> vehicles) {
        // helper method - displays the list and can be called from all the get-vehicles type method
        // this method should have a parameter that is passed in containing the vehicles to list
        // within the method, create a loop and display the vehicles
        // format this to display more aesthetically for the user
        for (Vehicle v : vehicles) System.out.println(v);
    }


    public void processGetByPriceRequest() {
        // get min/max from the user
        System.out.print("Please enter a minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Please enter a maximum price: ");
        double max = scanner.nextDouble();
        
        List<Vehicle> vehiclePrices = dealership.getVehiclesByPrice(min, max);
        displayVehicle(vehiclePrices);
    }

    public void processGetMyMakeModelRequest() {
        // get make/model from the user
        System.out.print("Please enter the Make of the vehicle to search: ");
        String make = scanner.nextLine();
        System.out.print("Please enter the Model of the vehicle to search: ");
        String model = scanner.nextLine();
        
        List<Vehicle> vehicleMake = dealership.getVehiclesByMake(make);
        List<Vehicle> vehicleModel = dealership.getVehiclesByMake(model);
        displayVehicle(vehicleMake);
        displayVehicle(vehicleModel);
    }

    public void processGetByYearRequest() {
        // get min/max year of vehicle from the user
        System.out.print("Please enter the min year of the vehicle to search: ");
        double min = scanner.nextDouble();
        System.out.print("Please enter the max year of the vehicle to search; ");
        double max = scanner.nextDouble();
        
        List<Vehicle> vehicleYear = dealership.getVehiclesByYear(min, max);
        displayVehicle(vehicleYear);
    }

    public void processGetByColorRequest() {
        // get color of vehicle from the user
        System.out.print("Please enter the color of the vehicle to search: ");
        String color = scanner.nextLine();
        
        List<Vehicle> vehicleColor = dealership.getVehiclesByColor(color);
        displayVehicle(vehicleColor);
    }

    public void processGetByMileageRequest() {
        // get mileage of vehicle from the user
        System.out.print("Please enter the minimum mileage of the vehicle to search: ");
        double min = scanner.nextDouble();
        System.out.print("Please enter the maximum mileage of the vehicle to search: ");
        double max = scanner.nextDouble();
        
        List<Vehicle> vehicleMileage = dealership.getVehiclesByMileage(min, max);
        displayVehicle(vehicleMileage);
    }

    public void processGetByVehicleTypeRequest() {
        // get vehicle type from the user
        System.out.print("Please enter the vehicle type to search: ");
        String type = scanner.nextLine();
        
        List<Vehicle> vehicleType = dealership.getVehiclesByType(type);
        displayVehicle(vehicleType);
    }

    public void processGetAllVehiclesRequest() {
        // list all vehicles in the dealership
        // this method will be used to test that we successfully load the dealership and vehicles from the file
        // call the dealership's getAllVehicles() method
        // call the displayVehicles() helper method and pass it the list that is returned from getAllVehicles()
        displayVehicle(dealership.getAllVehicles());
    }

    public void processRemoveVehicleRequest() {
        // get a vehicle to remove from the List<Vehicle> inventory - in the Dealership class
        System.out.print("Please enter the vin number of the vehicle you would like to take off the lot: ");
        int vin = scanner.nextInt();
        
        List<Vehicle> vehicleVin = dealership.getVehicleByVIN(vin);
        displayVehicle(vehicleVin);
        // add method to save the removal of the vehicle to the csv file
    }
}