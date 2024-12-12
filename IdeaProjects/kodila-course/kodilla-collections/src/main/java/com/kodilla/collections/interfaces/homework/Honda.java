package com.kodilla.collections.interfaces.homework;

public class Honda implements Car {
    private int speed;

    public Honda() {
        this.speed = 0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed() {
        speed += 27;
    }

    @Override
    public void decreaseSpeed() {
        speed -= 16;
    }
}
