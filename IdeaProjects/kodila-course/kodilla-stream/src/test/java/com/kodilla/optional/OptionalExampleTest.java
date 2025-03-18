package com.kodilla.optional;

import com.kodilla.stream.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OptionalExampleTest {

    @Test
    void shouldPrintUsernameWhenUserIsPresent() {
        // Given
        User user = new User("user1", 30, 100, "Test");
        Optional<User> optionalUser = Optional.of(user);

        // When
        optionalUser.ifPresent(u -> System.out.println(u.getUsername()));

        // Mockito mock
        User mockedUser = Mockito.mock(User.class);
        Mockito.when(mockedUser.getUsername()).thenReturn("user1");

        Optional<User> optionalMockUser = Optional.of(mockedUser);

        // When
        optionalMockUser.ifPresent(u -> System.out.println(u.getUsername()));

        // Then
        verify(mockedUser).getUsername();  // Verifying that mockedUser's getUsername() was called
    }

    @Test
    void shouldNotThrowExceptionWhenUserIsAbsent() {
        // Given
        Optional<User> emptyOptional = Optional.empty();

        // When & Then
        assertDoesNotThrow(() -> emptyOptional.ifPresent(user -> System.out.println(user.getUsername())));
    }
}