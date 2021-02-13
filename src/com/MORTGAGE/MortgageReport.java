package com.MORTGAGE;

import java.text.NumberFormat;

public class MortgageReport {
    // here we are calling mortgageCalculator of the Main Class: Main.mortgageCalculator
    // it shall not be there because it is a part of another class for calculating mortgage

    public static void printMortgage(int principle, float annualInterestRate, byte years) {
        Double mortgage = Main.mortgageCalculator(principle, annualInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE: ");
        System.out.println("----------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(int principle, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("Payment Schedule: ");
        System.out.println("-------------------");
        for (short numberOfPaymentsMade = 1; numberOfPaymentsMade <= years * Main.MONTH_IN_YEAR; numberOfPaymentsMade++) {
            Double balance = Main.calculateBalance(principle, annualInterestRate, years, numberOfPaymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
