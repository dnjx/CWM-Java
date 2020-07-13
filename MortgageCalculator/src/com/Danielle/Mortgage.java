package com.Danielle;

public class Mortgage {
    final static short MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    private short numPaymentsMade = 0;
    private int principal;
    private byte loanPeriod;
    private double monthlyInterestRate;
    private double monthlyPayment;
    private float interestAmount;
    private float annualInterestRate;
    private short numPayments;
    private double balance;
    public double[] balances;

    public Mortgage() {
        setPrincipal();
        setInterestAmounts();
        setLoanPeriod();
        numPayments = (short)(loanPeriod * MONTHS_IN_YEAR);
        calculateMortgage();
        balances = calculatePaymentSchedule();
    }

    private void setInterestAmounts() {
        float minInterest = 1;
        float maxInterest = 30;
        String prompt = "Interest: ";
        interestAmount = (float) Terminal.readNumber(prompt, minInterest, maxInterest);
        annualInterestRate = interestAmount / PERCENT;
        monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
    }

    private byte getLoanPeriod() {
        return loanPeriod;
    }

    private void setLoanPeriod() {
        byte minLoanPeriod = 1;
        byte maxLoanPeriod = 30;
        String prompt = "Loan Period: ";
        loanPeriod = (byte) Terminal.readNumber(prompt, minLoanPeriod, maxLoanPeriod);
//        this.loanPeriod = loanPeriod;
    }

    private int getPrincipal() {
        return principal;
    }

    private void setPrincipal() {
        int minPrincipal = 1000;
        int maxPrincipal = 1000000;
        String prompt = "Principal: ";
        principal = (int)Terminal.readNumber(prompt, minPrincipal, maxPrincipal);
    }


    public void calculateMortgage() {
        monthlyPayment = principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numPayments))) /
                ((Math.pow(1 + monthlyInterestRate, numPayments)) - 1);
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    private double calculateBalance(short numPaymentsMade) {
        double value = (principal*((Math.pow(1+monthlyInterestRate, numPayments)) - (Math.pow(1+monthlyInterestRate, numPaymentsMade)))) /
                (Math.pow(1+monthlyInterestRate, numPayments)-1);
        return value;
    }

    private double[] calculatePaymentSchedule() {
        double[] balances = new double[numPayments + 1];
        for (short month = numPaymentsMade, i = 0; month <= loanPeriod * Mortgage.MONTHS_IN_YEAR; month++, i++) {
            balances[i] = calculateBalance(month);
        }
        return balances;
    }

    public double getBalance() {
        return balance;
    }
}
