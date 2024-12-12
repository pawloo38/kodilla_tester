package com.kodilla.collections.interfaces.homework;

public class Ford implements Car {
    private int speed;

    public Ford() {
        this.speed = 0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed += 30;
    }

    @Override
    public void decreaseSpeed() {
        speed -= 15;
    }
}
