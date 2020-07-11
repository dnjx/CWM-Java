package com.Danielle;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int)readNumber("Principal: ", 1000 ,1000000);
        float interestAmount = (float)readNumber("Annual interest rate: ", 1, 30);
        byte loanPeriod = (byte)readNumber("Loan period (Years): ", 1, 30);

        double monthlyPayment = calculateMortgate(principal, interestAmount, loanPeriod);

        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println("Your monthly payment is: "  + monthlyPaymentFormatted);
    }

    public static double readNumber (String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgate(
            int principal,
            double interestAmount,
            byte loanPeriod) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numPayments = (short)(loanPeriod * MONTHS_IN_YEAR);
        double annualInterestRate = interestAmount / PERCENT;
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        double monthlyPayment = principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numPayments))) /
                ((Math.pow(1 + monthlyInterestRate, numPayments)) - 1);
        return monthlyPayment;
    }

}
