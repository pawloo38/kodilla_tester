package com.kodilla.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsersManagerTest {
    @Test
    public void testFilterChemistGroupUsernames() {
        List<String> usernames = UsersManager.filterChemistGroupUsernames();
        List<String> expectedUsernames = List.of("Walter White", "Gale Boetticher");
        assertEquals(expectedUsernames, usernames);
    }

    @Test
    public void testFilterUsersByAge() {
        List<User> filteredUsers = UsersManager.filterUsersByAge(40);
        assertTrue(filteredUsers.stream().allMatch(user -> user.getAge() > 40));
    }

    @Test
    public void testFilterActiveYoungUsers() {
        List<User> filtredUsers = UsersManager.filterActiveYoungUsers();
        assertTrue(filtredUsers.stream().allMatch(user -> user.getAge() < 35 && user.getNumberOfPost() > 100));
    }
}