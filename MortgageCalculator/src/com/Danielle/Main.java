package com.Danielle;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //principal annual interest rate period
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final int MIN_PRINCIPAL = 1000;
        final int MAX_PRINCIPAL = 1_000_000;

        int principal = 0;
        double interestAmount = 0.0;
        byte loanPeriod = 0;
        double annualInterestRate = 0.0;
        double monthlyInterestRate = 0.0;
        int numPayments = 0;
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= MIN_PRINCIPAL && principal <= MAX_PRINCIPAL)
                break;
            System.out.println("Invalid amount. Please enter a principal amount between $1k and $1M.");
        }
        while (true) {
            System.out.print("Annual interest rate: ");
            interestAmount = scanner.nextDouble();
            if (interestAmount > 0.0 && interestAmount <= 30) {
                annualInterestRate = interestAmount / PERCENT;
                monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Invalid amount. Please enter an interest rate between 0.1% and 30%.");
        }
        while (true) {
            System.out.print("Loan period:  ");
            loanPeriod = scanner.nextByte();
            if(loanPeriod >= 1 && loanPeriod <= 30) {
                numPayments = loanPeriod * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Invalid period. Please enter a loan period between 1 & 30 years.");
        }

        double numerator = monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numPayments));
        double denominator = (Math.pow(1 + monthlyInterestRate, numPayments)) - 1;
        double monthly_payment = principal * (numerator/denominator);

        String monthly_payment_formatted = NumberFormat.getCurrencyInstance().format(monthly_payment);
        System.out.println("Your principal amount is: " + principal);
        System.out.println("Your annual interest rate is: " + annualInterestRate);
        System.out.println("Your load period is: " + loanPeriod + " years");
        System.out.println("Your monthly payment is: "  + monthly_payment_formatted);

    }
}
