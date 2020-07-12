package com.Danielle;

public class Main {

    public static void main(String[] args) {
        var employee = new Employee();
        employee.setBaseSalary(800);
        employee.setHourlyRate(15);
        int wage = employee.calculateWage(2);
        System.out.println(wage);

    }
}
