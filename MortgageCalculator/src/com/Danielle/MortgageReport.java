package com.Danielle;

import java.text.NumberFormat;
import java.util.Arrays;

public class MortgageReport {
//    private double monthlyPayment = ;
//    private String monthlyPaymentFormatted;

    public static void printMortgage(double monthlyPayment) {
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        String header = "Mortgage \n" + "_______ \n" + "Monthly payments of: ";
        Terminal.printReport(header, monthlyPaymentFormatted);
    }

    public static void printPaymentSchedule(double[] balances ) {
        System.out.println( "\nPayment Schedule  \n" + "________________ \n");
        String[] balancesFormatted = new String[balances.length];
        for(int i = 0; i < balances.length; i++) {
            balancesFormatted[i] = "Balance end of month " + i + " : " + NumberFormat.getCurrencyInstance().format(balances[i]);
            Terminal.printReport(balancesFormatted[i]);
        }
    }

}
