package wallet;

public class Cashier {
    private final CashSlot cashSlot;

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdraw(Wallet wallet, int amount) {
        if (wallet.getBalance() >= amount) {
            cashSlot.dispense(amount);
            wallet.withdraw(amount);
        } else {
            throw new InsufficientFundsException("Not enough funds in wallet");
        }
    }
}