Feature: FizzBuzz
  As a user
  I want to get the correct text output based on a number
  So that I can easily understand the result based on divisibility by 3 and 5

  Scenario Outline: Check the number divisibility
    Given I have the number <number>
    When I process the number
    Then the result should be "<expected_result>"

    Examples:
      | number | expected_result |
      | 3      | Fizz            |
      | 5      | Buzz            |
      | 15     | FizzBuzz        |
      | 7      | None            |