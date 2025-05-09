package com.pluralsight;

public class Vehicle {
    private int vin;
    private double price;
    private String makeModel;
    private String year;
    private String color;
    private double mileage;
    private String type;

    public Vehicle(int vin, String year, String makeModel, String type, String color, double mileage, double price) {
        this.vin = vin;
        this.year = year;
        this.makeModel = makeModel;
        this.type = type;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%.2f, %s, %f, %s, %d, %s", price, makeModel, year, color, mileage, type);
    }
}
