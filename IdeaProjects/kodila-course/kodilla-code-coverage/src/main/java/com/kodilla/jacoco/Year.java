package com.kodilla.jacoco;

public class Year {
    int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isLeap() {
        if (this.year % 400 == 0) {
            return true;
        } else if (this.year % 100 == 0) {
            return false;
        } else if (this.year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
