package com.kodilla.notification.homework;

import com.kodilla.notification.Notification;

public class WeatherNotification implements Notification {
    private String message;

    public WeatherNotification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
