package com.MORTGAGE;

public class Calculator {

    public static final byte MONTH_IN_YEAR = 12;
    public static final byte PERCENT = 100;

    private int principle;
    private float annualInterestRate;
    private byte years;

    public Calculator(int principle, float annualInterestRate, byte years) {
        this.principle = principle;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {

        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayments = getNumberOfPayments();

        return principle
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

    }

    public double mortgageCalculator() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayments = getNumberOfPayments();

        return principle
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfPayments))
                / (Math.pow(monthlyInterestRate + 1, numberOfPayments) - 1);

    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short numberOfPaymentsMade = 1; numberOfPaymentsMade <= balances.length; numberOfPaymentsMade++) {
            balances[numberOfPaymentsMade -1] = calculateBalance(numberOfPaymentsMade);
        }
        return balances;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTH_IN_YEAR);
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTH_IN_YEAR;
    }


// we omit it because after making getRemainingBalances() and omitting 3 lines in MortgageReporter
//  we it is never used and it id redundant.

   /*
    public short getYears() { return years;}
    */
}
