package wallet.homework;

import wallet.InsufficientFundsException;

public class Wallet {
    private int balance = 0;

    public void deposit(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        this.balance += money;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough funds in wallet");
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
