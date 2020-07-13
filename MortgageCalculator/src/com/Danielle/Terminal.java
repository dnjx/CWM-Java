package com.Danielle;

import java.util.Scanner;

public class Terminal {
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

    public static void printReport(String header, String reportContents) {
        System.out.println(header);
        System.out.println(reportContents);
    }
    public static void printReport(String reportContents) {
        System.out.println(reportContents);
    }
}
