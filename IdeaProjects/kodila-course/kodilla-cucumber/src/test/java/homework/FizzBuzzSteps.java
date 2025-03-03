package homework;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static homework.FizzBuzz.checkFizzBuzz;

public class FizzBuzzSteps {
    private int number;
    private String result;

    @Given("I have the number {int}")
    public void i_have_the_number(Integer number) {
        this.number = number;
    }

    @When("I process the number")
    public void i_process_the_number() {
        this.result = checkFizzBuzz(this.number);
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
        assertEquals(expectedResult, this.result);
    }
}
