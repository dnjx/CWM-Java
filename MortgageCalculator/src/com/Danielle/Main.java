package com.Danielle;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
//    final static short MONTHS_IN_YEAR = 12;
//    final static byte PERCENT = 100;

    public static void main(String[] args) {
        var mortgage = new Mortgage();
        MortgageReport.printMortgage(mortgage.getMonthlyPayment());
        MortgageReport.printPaymentSchedule(mortgage.balances);
    }
}
