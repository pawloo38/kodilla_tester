package com.kodilla.bank.homework;

public class Bank {
    static CashMachine[] cashMachines;
    public Bank(int numberOfMachines) {
        cashMachines = new CashMachine[numberOfMachines];
        for (int i = 0; i < numberOfMachines; i++) {
            cashMachines[i] = new CashMachine();
        }
    }
    public static double getTotalBalance() {
        double totalBalance = 0;
        for (CashMachine machine : cashMachines) {
            totalBalance += machine.getBalance();
        }
        return totalBalance;
    }
    public static int getTotalWithdrawalTransactions() {
        int totalWithdrawals = 0;
        for (CashMachine machine : cashMachines) {
            totalWithdrawals += machine.getWithdrawalCount();
        }
        return totalWithdrawals;
    }
    public static int getTotalDepositTransactions() {
        int totalDeposits = 0;
        for (CashMachine machine : cashMachines) {
            totalDeposits += machine.getDepositCount();
        }
        return totalDeposits;
    }
    public static double getAverageWithdrawal() {
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
    public static double getAverageDeposit() {
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
