package com.MORTGAGE;

import java.text.NumberFormat;

public class Main {
    static final byte MONTH_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {

        int principle = (int) Console.readNumber("Principle ( € 1K - € 1M) : ", 1_000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("AnnualInterestRate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (year): ", 1, 30);

        printMortgage(principle, annualInterestRate, years);
        printPaymentSchedule(principle, annualInterestRate, years);
    }

    private static void printMortgage(int principle, float annualInterestRate, byte years) {
        Double mortgage = mortgageCalculator(principle, annualInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE: ");
        System.out.println("----------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principle, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("Payment Schedule: ");
        System.out.println("-------------------");
        for (short numberOfPaymentsMade = 1; numberOfPaymentsMade<= years * MONTH_IN_YEAR; numberOfPaymentsMade++){
            Double balance = calculateBalance (principle, annualInterestRate, years, numberOfPaymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));}
    }

    public static double calculateBalance(
            int principle,
            float annualInterestRate,
            byte years,
            short numberOfPaymentsMade
    ){
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;
        short numberOfPayments = (short) (years * MONTH_IN_YEAR);

        return principle
                * ( Math.pow( 1+ monthlyInterestRate, numberOfPayments) - Math.pow(1+ monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1+ monthlyInterestRate, numberOfPayments) - 1);

    }

    public static double mortgageCalculator(
            int principle,
            float annualInterestRate,
            byte years
    ){
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;
        short numberOfPayments = (short) (years * MONTH_IN_YEAR);

        return principle
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfPayments))
                / (Math.pow(monthlyInterestRate + 1, numberOfPayments) - 1);

    }
}
