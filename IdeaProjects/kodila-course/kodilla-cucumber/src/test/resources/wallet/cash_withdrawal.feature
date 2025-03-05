Feature: Cash Withdrawal
    Scenario: Successful withdrawal from a wallet in credit
        Given I have deposited $200 in my wallet
        When  I request $30
        Then  $30 should be dispensed

    Scenario: Successful withdrawal of the entire balance
        Given I have deposited $200 in my wallet
        When I request $200
        Then $200 should be dispensed

    Scenario: Unsuccessful withdrawal due to insufficient funds
        Given I have deposited $200 in my wallet
        When I request $300
        Then I should not be able to withdraw $300
        And $0 should be dispensed

    Scenario: Withdrawal of zero dollars
        Given I have deposited $200 in my wallet
        When I request $0
        Then $0 should be dispensed

    Scenario: Deposit of zero dollars
        Given I have deposited $0 in my wallet
        Then my wallet balance should be $0

    Scenario: Deposit of negative amount
        Given I try to deposit -$50 in my wallet
        Then my wallet balance should not change
        And my wallet balance should still be $0

    Scenario: Successful withdrawal of the entire balance (repeated scenario)
        Given I have deposited $500 in my wallet
        When I request $500
        Then $500 should be dispensed