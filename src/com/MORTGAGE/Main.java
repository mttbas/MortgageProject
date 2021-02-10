package com.MORTGAGE;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Mortgage Calculator: ");
        System.out.println("---------------------");

        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principle;
        float monthlyInterestRate;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        // infinite LOOP while (true){}
        while (true) {
            System.out.print("Principle ( € 1K - € 1M) : ");
            principle = scanner.nextInt();
            if (principle>= 1_000 && principle<= 1_000_000) // for one statement we need no {} for IF
                break;
            System.out.println("Enter a value between 1000 and 1000000 ");
        }

        while (true){
            System.out.print("AnnualInterestRate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate>=1 && annualInterestRate<=30) { // for more that 1 statement we need no {} for IF
                monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }


        while (true) {
            System.out.print("Period (year): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30){
                numberOfPayments = years * MONTH_IN_YEAR;
            break;
        }
            System.out.println("Enter a value between 1 and 30");
        }



        double mortgage = principle
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfPayments))
                / (Math.pow(monthlyInterestRate + 1, numberOfPayments) - 1);


        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        // or
        System.out.println("Mortgage: " + (NumberFormat.getCurrencyInstance().format(mortgage)));

    }
}
