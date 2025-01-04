package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UserRepository;

import java.util.List;
import java.util.OptionalDouble;

public class ForumStatus {

    public static OptionalDouble averagePostsForUsersOver40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 40)
                .mapToInt(User::getNumberOfPost)
                .average();
    }

    public static OptionalDouble averagePostsForUsersUnder40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() < 40)
                .mapToInt(User::getNumberOfPost)
                .average();
    }

    public static void main(String[] args) {
        List<User> users = UserRepository.getUserList();
        OptionalDouble avgPostsOver40 = averagePostsForUsersOver40(users);
        OptionalDouble avgPostsUnder40 = averagePostsForUsersUnder40(users);
        System.out.println("Srednia liczba postow dla uzytkownikow powyzej 40 roku zycia to: " + (avgPostsOver40.isPresent() ? avgPostsOver40.getAsDouble() : "Brak uzytkownikow"));
        System.out.println("Srednia liczba postow dla uzytkownikow ponizej 40 roku zycia to: " + (avgPostsUnder40.isPresent() ? avgPostsUnder40.getAsDouble() : "Brak uzytkownikow"));
    }

}
