package com.Danielle;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static short MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int)readNumber("Principal: ", 1000 ,1000000);
        float interestAmount = (float)readNumber("Annual interest rate: ", 1, 30);
        byte loanPeriod = (byte)readNumber("Loan period (Years): ", 1, 30);

        printMortgage(principal, interestAmount, loanPeriod);

        printPaymentSchedule(principal, interestAmount, loanPeriod);
    }

    public static void printMortgage(int principal, float interestAmount, byte loanPeriod) {
        double monthlyPayment = calculateMortgate(
                principal,
                calculateMonthlyInterestRate(interestAmount),
                calculateNumPayments(loanPeriod));
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println("Mortgage");
        System.out.println("_______");
        System.out.println("Monthly payments of: "  + monthlyPaymentFormatted);
    }

    public static void printPaymentSchedule(int principal, float interestAmount, byte loanPeriod) {
        System.out.println();
        System.out.println("Payment schedule");
        System.out.println("----------------");
        for (short month = 1; month <= loanPeriod * MONTHS_IN_YEAR; month++ ) {
            double balance = calculateBalance(principal,
                    calculateMonthlyInterestRate(interestAmount),
                    calculateNumPayments(loanPeriod),
                    month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println("Balance end of month " + month + ": " + balanceFormatted);
        }
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

    public static double calculateMonthlyInterestRate(double interestAmount) {
        double annualInterestRate = interestAmount / PERCENT;
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;

        return monthlyInterestRate;
    }

    public static short calculateNumPayments(short loanPeriod) {
        short MONTHS_IN_YEAR = 12;
        short numPayments = (short)(loanPeriod * MONTHS_IN_YEAR);

        return numPayments;
    }

    public static double calculateMortgate(
            int principal,
            double monthlyInterestRate,
            short numPayments) {
        double monthlyPayment = principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numPayments))) /
                ((Math.pow(1 + monthlyInterestRate, numPayments)) - 1);
        return monthlyPayment;
    }

    public static double calculateBalance(
            int principal,
            double monthlyInterestRate,
            short numPayments,
            short numPaymentsMade) {
        double balance = (principal*((Math.pow(1+monthlyInterestRate, numPayments)) - (Math.pow(1+monthlyInterestRate, numPaymentsMade)))) /
                    (Math.pow(1+monthlyInterestRate, numPayments)-1);

        return balance;
    }
}
