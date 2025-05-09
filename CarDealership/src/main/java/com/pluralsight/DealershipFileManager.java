package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    public static String filePath = "inventory.csv";
    
    public static Dealership getDealership() {
        // get dealership details from csv file
        String details;
        int lineNumber = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            details = reader.readLine();

            // after reading a line from the file, we want to parse the information
            // this information will be saved to the new Dealership object
            String[] dealershipDetails = details.split("\\|");

            String dealershipName = dealershipDetails[0];
            String dealershipAddress = dealershipDetails[1];
            String dealershipPhoneNumber = dealershipDetails[2];

            Dealership dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhoneNumber);

            // details != null is always true so use the true boolean and a break statement to loop
            while (true) {
                String[] vehicleDetails = details.split("\\|");

                if (vehicleDetails.length != 8) {
                    System.out.println("There are some vehicle details missing!");
                    continue;
                }

                try {
                    Vehicle vehicle = getVehicle(vehicleDetails);
                    dealership.addVehicle(vehicle);
                    break;
                } catch (Exception e) {
                    System.out.println("There was an error parsing vehicle details!");
                    throw new RuntimeException(e);
                }
            }
            // after parsing the details, we return the new Dealership object
            return dealership;
            
        } catch (IOException e) {
            System.out.println("Could not read from file!");
            throw new RuntimeException(e);
        }
    }

    // extrapolated a getVehicle method to parse the details and return a Vehicle object
    private static Vehicle getVehicle(String[] vehicleDetails) {
        int vin = Integer.parseInt(vehicleDetails[0]);
        String year = vehicleDetails[1];
        String make = vehicleDetails[2];
        String model = vehicleDetails[3];
        String type = vehicleDetails[4];
        String color = vehicleDetails[5];
        double mileage = Double.parseDouble(vehicleDetails[6]);
        double price = Double.parseDouble(vehicleDetails[7]);

        return new Vehicle(vin, year, make, model, type, color, mileage, price);
    }
    
    private static void saveDealership(Dealership dealership){
      // will add code to save a dealership 
        // this method will overwrite the inventory.csv file
        // with the provided dealership information and inventory list
    }
}