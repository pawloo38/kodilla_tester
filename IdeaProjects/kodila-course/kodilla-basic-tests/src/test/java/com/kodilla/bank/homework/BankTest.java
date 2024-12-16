package com.kodilla.bank.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @BeforeEach
    public void setUp() {
        Bank twoCashMachines = new Bank(2);
        Bank threeCashMachines = new Bank(3);
    }

    @Test
    void TestTotalBalance() {
        Bank.cashMachines[0].deposit(100);
        Bank.cashMachines[1].deposit(200);
        Bank.cashMachines[2].withdraw(-50);
        assertEquals(250, Bank.getTotalBalance());
    }

    @Test
    void testTotalWithdrawalTransactions() {
        Bank.cashMachines[0].withdraw(-50);
        Bank.cashMachines[1].withdraw(-100);
        Bank.cashMachines[1].deposit(150);
        assertEquals(2, Bank.getTotalWithdrawalTransactions());
    }

    @Test
    void testTotalDepositTransactions() {
        Bank.cashMachines[0].deposit(200);
        Bank.cashMachines[1].deposit(300);
        Bank.cashMachines[1].withdraw(-150);
        assertEquals(1, Bank.getTotalDepositTransactions());
    }

    @Test
    void testAverageWithdrawal() {
        Bank.cashMachines[0].withdraw(-50);
        Bank.cashMachines[1].withdraw(-100);
        Bank.cashMachines[1].deposit(150);
        assertEquals(75, Bank.getAverageWithdrawal());
    }

    @Test
    void testAverageDeposit() {
        Bank.cashMachines[0].deposit(200);
        Bank.cashMachines[1].deposit(300);
        Bank.cashMachines[1].withdraw(-150);
        assertEquals(300, Bank.getAverageDeposit());
    }

    @Test
    void testEdgeCases() {
        assertEquals(0, Bank.getTotalBalance());
        assertEquals(0, Bank.getTotalWithdrawalTransactions());
        assertEquals(0, Bank.getTotalDepositTransactions());
        assertEquals(0, Bank.getAverageWithdrawal());
        assertEquals(0, Bank.getAverageDeposit());

        Bank.cashMachines[0].deposit(100);
        Bank.cashMachines[1].deposit(200);

        assertEquals(300, Bank.getTotalBalance());
        assertEquals(0, Bank.getTotalWithdrawalTransactions());
        assertEquals(0, Bank.getTotalDepositTransactions());
        assertEquals(0, Bank.getAverageDeposit());

        Bank.cashMachines[0].withdraw(-50);
        Bank.cashMachines[1].withdraw(-100);
        assertEquals(150, Bank.getTotalBalance());
        assertEquals(2, Bank.getTotalWithdrawalTransactions());
        assertEquals(2, Bank.getTotalDepositTransactions());
        assertEquals(75, Bank.getAverageWithdrawal());
    }
}