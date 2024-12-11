package com.kodilla.bank.homework;

public class Bank {
    CashMachine[] cashMachines;
    public Bank(int numberOfMachines) {
        this.cashMachines = new CashMachine[numberOfMachines];
        for (int i = 0; i < numberOfMachines; i++) {
            cashMachines[i] = new CashMachine();
        }
    }
    public double getTotalBalance() {
        double totalBalance = 0;
        for (CashMachine machine : cashMachines) {
            totalBalance += machine.getBalance();
        }
        return totalBalance;
    }
    public int getTotalWithdrawalTransactions() {
        int totalWithdrawals = 0;
        for (CashMachine machine : cashMachines) {
            totalWithdrawals += machine.getWithdrawalCount();
        }
        return totalWithdrawals;
    }
    public int getTotalDepositTransactions() {
        int totalDeposits = 0;
        for (CashMachine machine : cashMachines) {
            totalDeposits += machine.getDepositCount();
        }
        return totalDeposits;
    }
    public double getAverageWithdrawal() {
        int totalWithdrawals = getTotalWithdrawalTransactions();
        if (totalWithdrawals == 0) {
            return 0;
        }
        double sum = 0;
        for (CashMachine machine : cashMachines) {
            sum += machine.getAverageWithdrawal() * machine.getWithdrawalCount();
        }
        return  sum / totalWithdrawals;
    }
    public double getAverageDeposit() {
        int totalDeposits = getTotalDepositTransactions();
        if (totalDeposits == 0) {
            return 0;
        }
        double sum = 0;
        for (CashMachine machine : cashMachines) {
            sum += machine.getAverageDeposit() * machine.getDepositCount();
        }
        return sum / totalDeposits;
    }
}
