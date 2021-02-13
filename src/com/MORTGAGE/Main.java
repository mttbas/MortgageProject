package com.MORTGAGE;

public class Main {
    static final byte MONTH_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {

        int principle = (int) Console.readNumber("Principle ( € 1K - € 1M) : ", 1_000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("AnnualInterestRate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (year): ", 1, 30);

        var calculator = new Calculator(principle, annualInterestRate, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
