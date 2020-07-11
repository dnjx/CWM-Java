package com.Danielle;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int)readNumber("Principal: ", 1000 ,1000000);
        float interestAmount = (float)readNumber("Annual interest rate: ", 1, 30);
        byte loanPeriod = (byte)readNumber("Loan period (Years): ", 1, 30);

        double monthlyPayment = calculateMortgate(
                principal,
                calculateMonthlyInterestRate(interestAmount),
                calculateNumPayments(loanPeriod));
        calculateBalances(principal, calculateMonthlyInterestRate(interestAmount), calculateNumPayments(loanPeriod));

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

    public static double calculateMonthlyInterestRate(double interestAmount) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

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

    //TODO: Remove loop from method. Looping should be done in main method.
    public static void calculateBalances(
            int principal,
            double monthlyInterestRate,
            short numPayments) {
        double balance = principal;
        short paymentsMade = 1;
        while(balance > 0) {
            balance = (principal*((Math.pow(1+monthlyInterestRate, numPayments)) - (Math.pow(1+monthlyInterestRate, paymentsMade)))) /
                    (Math.pow(1+monthlyInterestRate, numPayments)-1);
             paymentsMade++;
             String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
             System.out.println(balanceFormatted);

        }
    }

}
