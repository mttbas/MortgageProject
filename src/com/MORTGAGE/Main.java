package com.MORTGAGE;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Mortgage Calculator: ");
        System.out.println("---------------------");

        int principle;
        float annualInterestRate;
        byte years;

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
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate>=1 && annualInterestRate<=30) // for more that 1 statement we need no {} for IF
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period (year): ");
           years = scanner.nextByte();
            if (years >= 1 && years <= 30)
            break;
            System.out.println("Enter a value between 1 and 30");
        }

        Double mortgage = mortgageCalculator(principle, annualInterestRate , years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        // or
        System.out.println("Mortgage: " + (NumberFormat.getCurrencyInstance().format(mortgage)));

    }


    public static double mortgageCalculator(
            int principle,
            float annualInterestRate,
            byte years
    ){
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;
        short numberOfPayments = (short) (years * MONTH_IN_YEAR);


        return principle
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfPayments))
                / (Math.pow(monthlyInterestRate + 1, numberOfPayments) - 1);

        /*
         Local variable 'mortgage' is redundant so we refactor = inline variable
         before we had this code:
         double mortgage = principle
                * (monthlyInterestRate * Math.pow( 1 + monthlyInterestRate, numberOfPayments))
               / (Math.pow( 1 + monthlyInterestRate, numberOfPayments) - 1 );
        return mortgage;
        */

    }
}
