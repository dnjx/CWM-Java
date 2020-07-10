package com.Danielle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte fizz_num = 5;
        final byte buzz_num = 3;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int user_num = scanner.nextByte();

        if (user_num % fizz_num == 0 && user_num%buzz_num == 0)
            System.out.println("FizzBuzz");
        else if (user_num%fizz_num == 0)
            System.out.println("Fizz");
        else if (user_num%buzz_num == 0)
            System.out.println("Buzz");
        else System.out.println(user_num);
    }
}
