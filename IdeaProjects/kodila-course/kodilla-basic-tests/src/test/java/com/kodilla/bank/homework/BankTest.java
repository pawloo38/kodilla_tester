package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    @Test
    void TestTotalBalance() {
        Bank bank = new Bank(3);
        bank.cashMachines[0].deposit(100);
        bank.cashMachines[1].deposit(200);
        bank.cashMachines[1].withdraw(-50);
        assertEquals(250, bank.getTotalBalance());
    }
    @Test
    void testTotalWithdrawalTransactions() {
        Bank bank = new Bank(2);
        bank.cashMachines[0].withdraw(-50);
        bank.cashMachines[1].withdraw(-100);
        bank.cashMachines[1].deposit(150);
        assertEquals(2, bank.getTotalWithdrawalTransactions());
    }
    @Test
    void testTotalDepositTransactions() {
        Bank bank = new Bank(2);
        bank.cashMachines[0].deposit(200);
        bank.cashMachines[1].deposit(300);
        bank.cashMachines[1].withdraw(-150);
        assertEquals(1, bank.getTotalDepositTransactions());
    }
    @Test
    void testAverageWithdrawal() {
        Bank bank = new Bank(2);
        bank.cashMachines[0].withdraw(-50);
        bank.cashMachines[1].withdraw(-100);
        bank.cashMachines[1].deposit(150);
        assertEquals(75, bank.getAverageWithdrawal());
    }
    @Test
    void testAverageDeposit() {
        Bank bank = new Bank(2);
        bank.cashMachines[0].deposit(200);
        bank.cashMachines[1].deposit(300);
        bank.cashMachines[1].withdraw(-150);
        assertEquals(300, bank.getAverageDeposit());
    }
    @Test
    void testEdgeCases() {
        Bank bank = new Bank(2);
        assertEquals(0, bank.getTotalBalance());
        assertEquals(0, bank.getTotalWithdrawalTransactions());
        assertEquals(0, bank.getTotalDepositTransactions());
        assertEquals(0, bank.getAverageWithdrawal());
        assertEquals(0, bank.getAverageDeposit());

        bank.cashMachines[0].deposit(100);
        bank.cashMachines[1].deposit(200);

        assertEquals(300, bank.getTotalBalance());
        assertEquals(0, bank.getTotalWithdrawalTransactions());
        assertEquals(0, bank.getTotalDepositTransactions());
        assertEquals(0, bank.getAverageDeposit());

        bank.cashMachines[0].withdraw(-50);
        bank.cashMachines[1].withdraw(-100);
        assertEquals(150, bank.getTotalBalance());
        assertEquals(2, bank.getTotalWithdrawalTransactions());
        assertEquals(2, bank.getTotalDepositTransactions());
        assertEquals(75, bank.getAverageWithdrawal());
    }
}
