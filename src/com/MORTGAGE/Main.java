package com.MORTGAGE;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mortgage Calculator: ");
        System.out.println("---------------------");
        // by creating readNumber Method now we can get rid of while LOOPs
        // by calling the readNumber Method and giving the parameters( Q , min, max) in each case.
        // but we need to cast the Numbers to get the right type of variable.

        int principle = (int) readNumber("Principle ( € 1K - € 1M) : ", 1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("AnnualInterestRate: ", 1, 30);
        byte years = (byte) readNumber("Period (year): ", 1, 30);

        Double mortgage = mortgageCalculator(principle, annualInterestRate , years);
        System.out.println("Mortgage: " + (NumberFormat.getCurrencyInstance().format(mortgage)));
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

    }
}
