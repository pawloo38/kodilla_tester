package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ShippingCenterTestSuite {

    private ShippingCenter shippingCenter;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection");
        shippingCenter = context.getBean(ShippingCenter.class);
    }

    @Test
    void testSendPackageSuccess() {
        String result = shippingCenter.sendPackage("123 Main St", 20);
        assertEquals("Package delivered to: 123 Main St", result);
    }

    @Test
    void testSendPackageFailure() {
        String result = shippingCenter.sendPackage("123 Main St", 35);
        assertEquals("Package not delivered to: 123 Main St", result);
    }
}