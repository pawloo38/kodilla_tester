package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserValidatorTestSuite {
    private UserValidator userValidator = new UserValidator();

    @ParameterizedTest
    @CsvSource({"validUser, true", "user_123, true", "us, false", "user@name, false", "user@name!, false", "u$ername, false", "user-name, true"})
    public void shouldValidateUsername(String username, boolean expected) {
        boolean result = userValidator.validateUsername(username);
        if (expected) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }

    @ParameterizedTest
    @CsvSource({"example@domain.com, true", "user.name@domain.co, true", "username@domain, false", "@domain.com, false", "user@domain, false", "user@.com, false", "user@domain.toolongextension, false", "username@subdomain.domain.com, true"})
    public void shouldValidateEmail(String email, boolean expected) {
        boolean result = userValidator.validateEmail(email);
        if (expected) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }
}