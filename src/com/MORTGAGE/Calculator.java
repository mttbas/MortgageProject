package com.MORTGAGE;

public class Calculator {

    private int principle;
    private float annualInterestRate;
    private byte years;

    public Calculator(int principle, float annualInterestRate, byte years) {
        this.principle = principle;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {

        float monthlyInterestRate = annualInterestRate / Main.PERCENT / Main.MONTH_IN_YEAR;
        short numberOfPayments = (short) (years * Main.MONTH_IN_YEAR);

        return principle
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

    }

    public double mortgageCalculator() {
        float monthlyInterestRate = annualInterestRate / Main.PERCENT / Main.MONTH_IN_YEAR;
        short numberOfPayments = (short) (years * Main.MONTH_IN_YEAR);

        return principle
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfPayments))
                / (Math.pow(monthlyInterestRate + 1, numberOfPayments) - 1);

    }
    public short getYears() {
        return years;
    }
}
