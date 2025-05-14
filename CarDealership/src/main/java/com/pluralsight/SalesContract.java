package com.pluralsight;

public class SalesContract {
    private double salesTax = .5;
    private double recordingFee = 100;
    private double processingFee = 295;
    private boolean finance = false;
    private double financeMonthlyPayment = 4.25;
    
    public SalesContract(double salesTax, double recordingFee, double processingFee, boolean finance, double financeMonthlyPayment) {
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
        this.financeMonthlyPayment = financeMonthlyPayment;
    }
    
    
}