package com.MORTGAGE;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in); // we define it as class Field.

    // only for practicing- not needed here: Overloading Method
    // if min and max are not important or not entered.
    // in Main class if you type: Console.readNumber then you will see it is overloaded twice:
    // with one parameter and with 3 parameters.
    // readNumber and prompt are grayed out. because they are not used in Main Method.
    // here we are overloading it only for practice.
    public static double readNumber(String prompt){
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;
    }
}
