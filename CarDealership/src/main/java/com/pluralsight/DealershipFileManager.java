package com.pluralsight;

import java.io.*;
import java.util.List;
import static com.pluralsight.ColorCodes.*;

public class DealershipFileManager {
    public static String filePath = "inventory.csv";
    
    public Dealership getDealership() {
        // get dealership details from csv file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String details = reader.readLine();

            // after reading a line from the file, we want to parse the information
            // this information will be saved to the new Dealership object
            String[] dealershipDetails = details.split("\\|");

            String dealershipName = dealershipDetails[0];
            String dealershipAddress = dealershipDetails[1];
            String dealershipPhoneNumber = dealershipDetails[2];

            Dealership dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhoneNumber);


            
            String vehicleLines;
            while ((vehicleLines = reader.readLine()) != null) {
//                 System.out.println("Reading line: " + vehicleLines);
//                 helps determine what the reader.readLine() variable is reading
                
                String[] vehicleDetails = vehicleLines.split("\\|");
//                 System.out.println("Split into " + vehicleDetails.length + " parts");
//                 determines what the String[] is being passed and determines how many splits of data
                if (vehicleDetails.length != 8) {
                    System.out.println("There are some vehicle details missing!");
                    continue;
                }

                try {
                    Vehicle newVehicle = getVehicle(vehicleDetails);
                    dealership.addVehicle(newVehicle);
                } catch (Exception e) {
                    System.out.println("Could not add vehicles to inventory");
                }
            }
            // after parsing the details, we return the new Dealership object
            return printDealershipInfo(dealership);
            
        } catch (IOException e) {
            System.out.println("Could not read from file!");
            throw new RuntimeException(e);
        }
    }

    // extrapolated a getVehicle method to parse the details and return a Vehicle object
    public static Vehicle getVehicle(String[] vehicleDetails) {
        try {
            int vin = Integer.parseInt(vehicleDetails[0]);
            int year = Integer.parseInt(vehicleDetails[1]);
            String make = vehicleDetails[2];
            String model = vehicleDetails[3];
            String type = vehicleDetails[4];
            String color = vehicleDetails[5];
            double mileage = Double.parseDouble(vehicleDetails[6]);
            double price = Double.parseDouble(vehicleDetails[7]);
            
            return new Vehicle(vin, year, make, model, type, color, mileage, price);
        } catch (Exception e) {
            System.out.println("Error parsing vehicle details");
            return null;
        }
    }
    
    public void saveDealership(Dealership dealership){
    // for every add or removal of a vehicle
    // this method will be called to save this new information to the csv file
        // need this line of code to write this information into the csv file
        // this would include the information added or removed from the corresponding methods 
        List<Vehicle> inventory = dealership.getAllVehicles();
        // logic: because the addVehicle() and the removeVehicle() change the 


        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))){
            // creates the dealership information line
            writer.printf("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhoneNumber());
            
            for(Vehicle v: inventory) {
                writer.printf("\n%d|%s|%s|%s|%s|%s|%.0f|%.0f"
                        , v.getVin()
                        , v.getYear()
                        , v.getMake()
                        , v.getModel()
                        , v.getType()
                        , v.getColor()
                        , v.getMileage()
                        , v.getPrice());
            }
        } catch(IOException e){
            System.out.println("There was an error saving information to file");
        }
    }
    
    public static Dealership printDealershipInfo(Dealership dealership) {
        String name = dealership.getName();
        String address = dealership.getAddress();
        String phone = dealership.getPhoneNumber();
        
        String border = "=".repeat(60);
        
        System.out.println(border);
        // Each line is exactly 60 characters wide with formatting and background applied to the entire line
        System.out.print(BLACK_BACKGROUND + YELLOW);
        System.out.printf("  DEALERSHIP: %-47s", name);
        System.out.println(RESET);
        
        System.out.print(BLACK_BACKGROUND + YELLOW);
        System.out.printf("  Address:    %-47s", address);
        System.out.println(RESET);
        
        System.out.print(BLACK_BACKGROUND + YELLOW);
        System.out.printf("  Phone:      %-47s", phone);
        System.out.println(RESET);
        
        System.out.println(border);
        return dealership;
    }
    
    public  void printVehicleInventory(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles in inventory \n");
            return;
        }
        
        String[] headers = { "VIN", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price" };
        int[] columnWidths = { 8, 6, 12, 14, 12, 10, 10, 12 };
        
        StringBuilder border = new StringBuilder();
        for (int width : columnWidths) {
            border.append("+").append("-".repeat(width));
        }
        border.append("+");
        
        // Print header
        System.out.println(border);
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) {
            System.out.printf(" %-" + (columnWidths[i] - 2) + "s |", headers[i]);
        }
        System.out.println();
        System.out.println(border);
        
        // Print vehicle rows
        for (Vehicle v : vehicles) {
            System.out.printf("| %-" + (columnWidths[0] - 2) + "d ", v.getVin());
            System.out.printf("| %-" + (columnWidths[1] - 2) + "d ", v.getYear());
            System.out.printf("| %-" + (columnWidths[2] - 2) + "s ", v.getMake());
            System.out.printf("| %-" + (columnWidths[3] - 2) + "s ", v.getModel());
            System.out.printf("| %-" + (columnWidths[4] - 2) + "s ", v.getType());
            System.out.printf("| %-" + (columnWidths[5] - 2) + "s ", v.getColor());
//            System.out.printf("| %-" + (columnWidths[6] - 2) + ".1f ", v.getMileage());
//            System.out.printf("| $%-" + (columnWidths[7] - 3) + ".2f |\n", v.getPrice());
            
            
            // Format mileage as integer with commas
            String mileageFormatted = String.format("%,d", (int) v.getMileage());
            System.out.printf("| %" + (columnWidths[6] - 2) + "s ", mileageFormatted);
            
            // Format price as $#,###.##
            String priceFormatted = String.format("$%,.2f", v.getPrice());
            System.out.printf("| %" + (columnWidths[7] - 2) + "s |\n", priceFormatted);
        }
        
        System.out.println(border);
    }
}