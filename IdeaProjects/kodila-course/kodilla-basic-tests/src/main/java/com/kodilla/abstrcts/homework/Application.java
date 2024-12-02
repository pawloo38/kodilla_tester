package com.kodilla.abstrcts.homework;

public class Application {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);

        System.out.println("Kolo: ");
        System.out.println("Pole kola: " + circle.calculateArea());
        System.out.println("Obwod kola: " + circle.calculatePerimeter());

        System.out.println("Prostokat: ");
        System.out.println("Pole prostokata: " + rectangle.calculateArea());
        System.out.println("Obwod prostokata: " + rectangle.calculatePerimeter());

        System.out.println("Trojkat: ");
        System.out.println("Pole trojkata: " + triangle.calculateArea());
        System.out.println("Obwod trojkata: " + triangle.calculatePerimeter());


    }
}
