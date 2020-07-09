package com.Danielle;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
	//principal annual interest rate period
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your principal amount: ");
        int principal = scanner.nextInt();
        System.out.print("Enter your annual interest rate amount: ");
        Float interest_amount = scanner.nextFloat();
        System.out.print("Enter your period (in years): ");
        Byte loan_period = scanner.nextByte();

        Float annual_interest_rate = interest_amount /100;
        Float monthly_interest_rate = annual_interest_rate / 12;

        int num_payments = loan_period * 12;

        Double numerator = monthly_interest_rate * (Math.pow(1 + monthly_interest_rate, num_payments));
        Double denominator = (Math.pow(1 + monthly_interest_rate, num_payments)) - 1;
        Double monthly_payment = principal * (numerator/denominator);


        System.out.println("Your principal amount is: " + principal);
        System.out.println("Your annual interest rate is: " + annual_interest_rate);
        System.out.println("Your load period is: " + loan_period + " years");
        System.out.println("Your monthly payment is: "  + monthly_payment);

    }
}
