package com.MORTGAGE;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Mortgage Calculator: ");
        System.out.println("---------------------");


        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);


        System.out.print("Principle: ");
        int principle = scanner.nextInt();

        System.out.print("AnnualInterestRate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;

        System.out.print("Period (year): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTH_IN_YEAR;



        double mortgage = principle
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfPayments))
                / (Math.pow(monthlyInterestRate + 1, numberOfPayments) - 1);


        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        // or
        System.out.println("Mortgage: " + (NumberFormat.getCurrencyInstance().format(mortgage)));

    }
}
