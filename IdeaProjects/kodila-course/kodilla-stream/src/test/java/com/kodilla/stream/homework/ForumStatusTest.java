package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

class ForumStatusTest {

    @Test
    public void testAveragePostsForUsersOver40() {
        List<User> users = List.of(
                new User("Walter White", 50, 7, "Chemists"),
                new User("Gus Firing", 49, 0, "Board"),
                new User("Mike Ehrmantraut", 57, 0, "Security"),
                new User("Gale Boetticher", 44, 2, "Chemists")
        );

        OptionalDouble avg = ForumStatus.averagePostsForUsersOver40(users);

        assertTrue(avg.isPresent());
        assertEquals(2.25, avg.getAsDouble(), 0.01);
    }

    @Test
    public void testAveragePostsForUsersUnder40() {
        List<User> users = List.of(
                new User("Jessie Pinkman", 25, 4648, "Sales"),
                new User("Tuco Salamanca", 34, 116, "Manager"),
                new User("Gale Boetticher", 44, 2, "Chemists")
        );

        OptionalDouble avg = ForumStatus.averagePostsForUsersUnder40(users);

        assertTrue(avg.isPresent());
        assertEquals(2382.0, avg.getAsDouble(), 0.01);
    }

    @Test
    public void testNoUsersOver40() {
        List<User> users = List.of(
                new User("Jessie Pinkman", 25, 4648, "Sales"),
                new User("Tuco Salamanca", 34, 116, "Manager")
        );
        OptionalDouble avg = ForumStatus.averagePostsForUsersOver40(users);

        assertFalse(avg.isPresent());
    }

    @Test
    public void testNoUsersUnder40() {
        List<User> users = List.of(
                new User("Walter White", 50, 7, "Chemists"),
                new User("Gus Firing", 49, 0, "Board"),
                new User("Mike Ehrmantraut", 57, 0, "Security")
        );

        OptionalDouble avg = ForumStatus.averagePostsForUsersUnder40(users);
        assertFalse(avg.isPresent());
    }
}