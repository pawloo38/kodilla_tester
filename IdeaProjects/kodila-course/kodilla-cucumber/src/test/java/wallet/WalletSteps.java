package wallet;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class WalletSteps {
    private Wallet wallet;
    private CashSlot cashSlot;
    private Cashier cashier;

    @Before
    public void reset() {
        wallet = new Wallet();
        cashSlot = new CashSlot();
    }

    @Given("I have deposited ${int} in my wallet")
    public void i_have_deposited_amount_in_my_wallet(int amount) {
        wallet.deposit(amount);
        Assertions.assertThat(wallet.getBalance()).isEqualTo(amount);
    }

    @When("I request ${int}")
    public void i_request_amount(int amount) {
        cashier = new Cashier(cashSlot);
        try {
            cashier.withdraw(wallet, amount);
        } catch (InsufficientFundsException e) {
        }
    }

    @Then("${int} should be dispensed")
    public void amount_should_be_dispensed(int amount) {
        Assertions.assertThat(cashSlot.getContents()).isEqualTo(amount);
    }

    @Then("the balance of my wallet should be $170")
    public void the_balance_of_my_wallet_should_be_$170() {
        Assertions.assertThat(wallet.getBalance())
                .as("Incorrect wallet balance")
                .isEqualTo(170);
    }

    @Then("I should not be able to withdraw ${int}")
    public void i_should_not_be_able_to_withdraw_amount(int amount) {
        Assertions.assertThat(cashSlot.getContents()).isEqualTo(0);
    }

    @Then("my wallet balance should be ${int}")
    public void my_wallet_balance_should_be_amount(int amount) {
        Assertions.assertThat(wallet.getBalance()).isEqualTo(amount);
    }

    @Given("I try to deposit -${int} in my wallet")
    public void i_try_to_deposit_negative_amount_in_my_wallet(int amount) {
        try {
            wallet.deposit(-amount);
            Assertions.fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Then("my wallet balance should not change")
    public void my_wallet_balance_should_not_change() {
        Assertions.assertThat(wallet.getBalance()).isEqualTo(0);
    }

    @Then("my wallet balance should still be ${int}")
    public void my_wallet_balance_should_still_be(int expectedBalance) {
        Assertions.assertThat(wallet.getBalance()).isEqualTo(expectedBalance);
    }
}