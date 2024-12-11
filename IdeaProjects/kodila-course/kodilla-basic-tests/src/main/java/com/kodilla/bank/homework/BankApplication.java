package com.kodilla.bank.homework;

public class BankApplication {
    public static void main(String[] args) {
        Bank bank = new Bank(3);

        bank.cashMachines[0].deposit(100);
        bank.cashMachines[1].deposit(200);
        bank.cashMachines[1].withdraw(-50);
        bank.cashMachines[2].deposit(300);
        bank.cashMachines[2].withdraw(-100);
        System.out.println("Stan konta to: " + bank.getTotalBalance());
        System.out.println("Liczba wyplat z konta to: " + bank.getTotalWithdrawalTransactions());
        System.out.println("Liczba wplat na kont to: " + bank.getTotalDepositTransactions());
        System.out.println("Srednia wartosc wyplaty to: " + bank.getAverageWithdrawal());
        System.out.println("Srednia wartosc wplaty to: " + bank.getAverageDeposit());

        Bank emptyBank = new Bank(1);
        System.out.println("Zerowy stan konta");
        System.out.println("Calkowity bilans rachunku bankowego: " + emptyBank.getTotalBalance());
        System.out.println("Liczba wyplat z konta to: " + emptyBank.getTotalWithdrawalTransactions());
        System.out.println("Liczba wplat na kont to: " + emptyBank.getTotalDepositTransactions());
        System.out.println("Srednia wartosc wyplaty to: " + emptyBank.getAverageWithdrawal());
        System.out.println("Srednia wartosc wplaty to: " + emptyBank.getAverageDeposit());

        Bank depositOnlyBank = new Bank(2);
        depositOnlyBank.cashMachines[0].deposit(500);
        depositOnlyBank.cashMachines[0].deposit(700);
        System.out.println("Wplaty: ");
        System.out.println("Calkowity bilans rachunku bankowego: " + depositOnlyBank.getTotalBalance());
        System.out.println("Liczba wyplat z konta to: " + depositOnlyBank.getTotalWithdrawalTransactions());
        System.out.println("Liczba wplat na kont to: " + depositOnlyBank.getTotalDepositTransactions());
        System.out.println("Srednia wartosc wyplaty to: " + depositOnlyBank.getAverageWithdrawal());
        System.out.println("Srednia wartosc wplaty to: " + depositOnlyBank.getAverageDeposit());

        Bank withdrawalOnlyBank = new Bank(2);
        withdrawalOnlyBank.cashMachines[0].withdraw(-200);
        withdrawalOnlyBank.cashMachines[1].withdraw(-300);
        System.out.println("Wyplaty: ");
        System.out.println("Calkowity bilans rachunku bankowego: " + withdrawalOnlyBank.getTotalBalance());
        System.out.println("Liczba wyplat z konta to: " + withdrawalOnlyBank.getTotalWithdrawalTransactions());
        System.out.println("Liczba wplat na kont to: " + withdrawalOnlyBank.getTotalDepositTransactions());
        System.out.println("Srednia wartosc wyplaty to: " + withdrawalOnlyBank.getAverageWithdrawal());
        System.out.println("Srednia wartosc wplaty to: " + withdrawalOnlyBank.getAverageDeposit());
    }
}
