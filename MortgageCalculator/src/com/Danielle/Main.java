package com.Danielle;

import java.text.NumberFormat;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
	//principal annual interest rate period
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your principal amount: ");
        int principal = scanner.nextInt();
        System.out.print("Enter your annual interest rate amount: ");
        Float interest_amount = scanner.nextFloat();
        System.out.print("Enter your period (in years): ");
        Byte loan_period = scanner.nextByte();

        Float annualInterestRate = interest_amount / PERCENT;
        Float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;

        int num_payments = loan_period * MONTHS_IN_YEAR;

        Double numerator = monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, num_payments));
        Double denominator = (Math.pow(1 + monthlyInterestRate, num_payments)) - 1;
        Double monthly_payment = principal * (numerator/denominator);
        String monthly_payment_formatted = NumberFormat.getCurrencyInstance().format(monthly_payment);


        System.out.println("Your principal amount is: " + principal);
        System.out.println("Your annual interest rate is: " + annualInterestRate);
        System.out.println("Your load period is: " + loan_period + " years");
        System.out.println("Your monthly payment is: "  + monthly_payment_formatted);

    }
}
