package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PersonSources {

    static Stream<Arguments> providePersonDataForTestingBMI() {
        return Stream.of(
                Arguments.of(1.75, 70, "Normal (healthy weight)"),
                Arguments.of(1.70, 50, "Underweight"),
                Arguments.of(1.60, 40, "Severely underweight"),
                Arguments.of(1.80, 95, "Overweight"),
                Arguments.of(1.75, 105, "Obese Class I (Moderately obese)"),
                Arguments.of(1.95, 150, "Obese Class II (Severely obese)"),
                Arguments.of(1.85, 150, "Obese Class III (Very severely obese)"),
                Arguments.of(1.70, 140, "Obese Class IV (Morbidly Obese)"),
                Arguments.of(1.80, 180, "Obese Class V (Super Obese)"),
                Arguments.of(1.75, 200, "Obese Class VI (Hyper Obese)")
        );
    }
}
