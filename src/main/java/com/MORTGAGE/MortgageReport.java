package com.MORTGAGE;

import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private Calculator calculator;
    // instead of var calculator = new Calculator(); we use it as INSTANCE FIELD in class level
    // here we are calling mortgageCalculator of the Main Class: Main.mortgageCalculator
    // it shall not be there because it is a part of another class for calculating mortgage

    public MortgageReport(Calculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        // error: because this method is no longer static, we need to create an OBJECT. but 
        // because we need this object in other method we define it as an INSTANCE FIELD and 
        // remove the static from the methods by making them refactor -INSTANCE
        Double mortgage = calculator.mortgageCalculator();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE: ");
        System.out.println("----------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("Payment Schedule: ");
        System.out.println("-------------------");
        for (double balance: calculator.getRemainingBalances())
        System.out.println(currency.format(balance));

        // instead of the below 3 lines we can use the 2 line Logic, making the Method getRemainingBalances
        // method in Calculator class
        // by omitting these lines we do not need getYears method and so we delete it from Calculator class

        /* for (short numberOfPaymentsMade = 1; numberOfPaymentsMade <= calculator.getYears() * Calculator.MONTH_IN_YEAR; numberOfPaymentsMade++) {
            Double balance = calculator.calculateBalance(numberOfPaymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        */
        }
}
