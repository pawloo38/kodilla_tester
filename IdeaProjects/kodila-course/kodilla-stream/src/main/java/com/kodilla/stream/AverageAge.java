package com.kodilla.stream;

public class AverageAge {
    public static void main(String[] args) {
        double avg = UserRepository.getUserList()
                .stream()
                .mapToInt(n -> n.getAge())
                .average()
                .getAsDouble();
        System.out.println(avg);
    }
}
