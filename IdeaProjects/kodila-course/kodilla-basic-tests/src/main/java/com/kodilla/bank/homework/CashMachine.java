package com.kodilla.bank.homework;

public class CashMachine {
    private double[] transactions;
    public CashMachine() {
        this.transactions = new double[0];
    }
    public void deposit(double amount){
        if (amount > 0) {
            addTransaction(amount);
        }
    }
    public void withdraw(double amount) {
        if (amount < 0) {
            addTransaction(amount);
        }
    }
    private void addTransaction(double amount) {
        double[] newTransactions = new double[transactions.length + 1];
        System.arraycopy(transactions, 0, newTransactions, 0 , transactions.length);
        newTransactions[transactions.length] = amount;
        transactions = newTransactions;
    }
    public double getBalance() {
        double balance = 0;
        for (double transaction : transactions) {
            balance+= transaction;
        }
        return balance;
    }
    public int getTransactionCount() {
        return transactions.length;
    }
    public int getDepositCount() {
        int count = 0;
        for (double transaction : transactions) {
            if (transaction < 0){
                count++;
            }
        }
        return count;
    }
    public int getWithdrawalCount() {
        int count = 0;
        for (double transaction : transactions) {
            if (transaction < 0) {
                count++;
            }
        }
        return count;
    }
    public double getAverageDeposit() {
        int depositCount = getDepositCount();
        if (depositCount == 0) {
            return 0;
        }
        double sum = 0;
        for (double transaction : transactions) {
            if (transaction > 0) {
                sum += transaction;
            }
        }
        return sum / depositCount;
    }
    public double getAverageWithdrawal () {
        int withdrawalCount = getWithdrawalCount();
        if (withdrawalCount == 0) {
            return 0;
        }
        double sum = 0;
        for (double transaction : transactions) {
            if (transaction < 0) {
                sum += Math.abs(transaction);
            }
        }
        return sum / withdrawalCount;
    }
}
