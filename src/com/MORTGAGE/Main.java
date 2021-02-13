package com.MORTGAGE;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        // by creating readNumber Method now we can get rid of while LOOPs
        int principle = (int) readNumber("Principle ( € 1K - € 1M) : ", 1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("AnnualInterestRate: ", 1, 30);
        byte years = (byte) readNumber("Period (year): ", 1, 30);

        // refactor ... extract ... 2 methods as printMortgage & printPaymentSchedule
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

    public static double readNumber(String prompt, double min, double max ){
        Scanner scanner = new Scanner(System.in);
        double value; // it shall be defined here not in while loop

        while (true){
            System.out.print(prompt); // is the question we ask from the user; calling this method we
            // can give in any question, any min or max. we do not need while loops.
            value = scanner.nextDouble(); // value is a general value instead of different numbers
            if (value>=min && value<=max) // for more that 1 statement we need no {} for IF
                break;
            System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;
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

        /* error: Local variable 'balance' is redundant. so we change the below statements
        using inline variable.
        double balance = principle
                * ( Math.pow( 1+ monthlyInterestRate, numberOfPayments) - Math.pow(1+ monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1+ monthlyInterestRate, numberOfPayments) - 1);

        return balance;
        */
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
