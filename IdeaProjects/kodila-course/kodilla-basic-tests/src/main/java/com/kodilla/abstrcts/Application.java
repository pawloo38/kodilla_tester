package com.kodilla.abstrcts;

public class Application {

    public static void main(String[] args) {
        testAnimalProcessor();
    }

    public static void testAnimalProcessor() {
        Animal dog = new Dog();
        AnimalProcessor processor = new AnimalProcessor();
        processor.process(dog);
    }
}
