package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection");

        Calculator calculator = context.getBean(Calculator.class);

        calculator.add(5, 3);
        calculator.subtract(5, 3);
        calculator.multiply(5, 3);
        calculator.divide(5, 0);
    }
}
