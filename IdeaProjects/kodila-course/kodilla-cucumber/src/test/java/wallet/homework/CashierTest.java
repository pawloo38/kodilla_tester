package wallet.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wallet.InsufficientFundsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashierTest {
    private CashSlot cashSlot;
    private Wallet wallet;
    private Cashier cashier;

    @BeforeEach
    void setUp() {
        cashSlot = new CashSlot();
        wallet = new Wallet();
        cashier = new Cashier(cashSlot);
    }

    @Test
    void testWithdrawSufficientFunds() {
        // Given
        wallet.deposit(100);
        int amountToWithdraw = 50;

        // When
        cashier.withdraw(wallet, amountToWithdraw);

        // Then
        assertEquals(50, wallet.getBalance(), "Saldo portfela powinno wynosić 50 po wypłacie.");
        assertEquals(50, cashSlot.getContents(), "CashSlot powinien zawierać 50 po wypłacie.");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        // Given
        wallet.deposit(30);
        int amountToWithdraw = 50;

        // When & Then
        InsufficientFundsException exception = assertThrows(InsufficientFundsException.class, () -> {
            cashier.withdraw(wallet, amountToWithdraw);
        }, "Powinien zostać rzucony wyjątek InsufficientFundsException.");

        assertEquals("Not enough funds in wallet", exception.getMessage(), "Komunikat wyjątku powinien być poprawny.");
        assertEquals(30, wallet.getBalance(), "Saldo portfela nie powinno się zmienić.");
        assertEquals(0, cashSlot.getContents(), "CashSlot nie powinien zawierać żadnych środków.");
    }

    @Test
    void testWithdrawExactFunds() {
        // Given
        wallet.deposit(100);
        int amountToWithdraw = 100;

        // When
        cashier.withdraw(wallet, amountToWithdraw);

        // Then
        assertEquals(0, wallet.getBalance(), "Saldo portfela powinno wynosić 0 po wypłacie.");
        assertEquals(100, cashSlot.getContents(), "CashSlot powinien zawierać 100 po wypłacie.");
    }
}
