package wallet.homework;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import wallet.CashSlot;
import wallet.Cashier;
import wallet.InsufficientFundsException;
import wallet.Wallet;

public class WalletSteps {private Wallet wallet;
    private CashSlot cashSlot;
    private Cashier cashier;
    private String message;

    @Before
    public void reset() {
        wallet = new Wallet();
        cashSlot = new CashSlot();
        cashier = new Cashier(cashSlot);
    }

    @Given("there is ${int} in my wallet")
    public void there_is_$_in_my_wallet(int amount) {
        wallet.deposit(amount);
        Assertions.assertThat(wallet.getBalance()).isEqualTo(amount);
    }

    @When("I withdraw ${int}")
    public void i_withdraw_$(int amount) {
        try {
            cashier.withdraw(wallet, amount);
        } catch (InsufficientFundsException e) {
            message = e.getMessage();
        }
    }

    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        Assertions.assertThat(cashSlot.getContents()).isEqualTo(0);
    }

    @Then("I should be told that I don't have enough money in my wallet")
    public void i_should_be_told_that_i_dont_have_enough_money_in_my_wallet() {
        Assertions.assertThat(message).isEqualTo("Not enough funds in wallet");
    }

    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
    }

    @Then("I should see that the balance is ${int}")
    public void i_should_see_that_the_balance_is_$(int expectedBalance) {
        Assertions.assertThat(wallet.getBalance()).isEqualTo(expectedBalance);
    }
}
