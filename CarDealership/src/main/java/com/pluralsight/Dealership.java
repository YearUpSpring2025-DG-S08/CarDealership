package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Vehicle> vehicles;
    public static String filePath = "inventory.csv";
    public static List<Vehicle> car = new ArrayList<>();

    // the constructor method of Dealership creates a new ArrayList of Vehicle
    // which will store the vehicles in the dealership
    public Dealership() {
        vehicles = new ArrayList<Vehicle>() {
        };
    }
    
    public static final List<Vehicle> inventoryList = getInventoryListFromCSV();
    
    // this method creates an array list of carDetails that will be parsed from the csv file
    // after being parsed within a String Array car, will add the information to the carDetails Array
    // combines two methods into one - getEncodedString method and getListFromEncodedString
    public static List<Vehicle> getInventoryListFromCSV(){
        List<Vehicle> carDetails = new ArrayList<>();
        
        // have to skip the first line for the dealership details
        // will work on that logic
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = reader.readLine()) != null){
                String[] car = line.split("//|");
                if(car.length == 7){
                    try{
                        int vin = Integer.parseInt(String.valueOf(carDetails.get(0)));
                        String year = String.valueOf(carDetails.get(1));
                        String makeModel = String.valueOf(carDetails.get(2));
                        String type = String.valueOf(carDetails.get(3));
                        String color = String.valueOf(carDetails.get(4));
                        double mileage = Double.parseDouble(String.valueOf(carDetails.get(5)));
                        double price = Double.parseDouble(String.valueOf(carDetails.get(6)));

                        carDetails.add(new Vehicle(vin, year, makeModel, type, color, mileage, price));
                    } catch (Exception e) {
                        System.out.println("There was an error parsing the data");
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not find the inventory list!");
            throw new RuntimeException(e);
        }
        return carDetails;
    }
    
//    public static Vehicle getVehiclesFromEncodedString(String encodedVehicles){
//        if(encodedVehicles == null || encodedVehicles.trim().isEmpty()){
//            return null;
//        }
//        
//        String[] carLot = encodedVehicles.trim().split("//|");
//        
//        if(carLot.length != 6){
//            System.out.println("There is some information missing for the vehicle");
//            return null;
//        }
//                
//        try{
//            String year = carLot[0].trim();
//            String makeModel = carLot[1].trim();
//            String type = carLot[2].trim();
//            String color = carLot[3].trim();
//            double mileage = Double.parseDouble(carLot[4]);
//            double price = Double.parseDouble(carLot[5]);
//            
//            return new Vehicle(year, makeModel, type, color, mileage, price);
//        } catch (Exception e) {
//            System.out.println("There was an error parsing the data");
//            throw new RuntimeException(e);
//        }
//    }
    
}
