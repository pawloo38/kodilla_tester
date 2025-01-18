package com.kodilla.notification.homework;

import com.kodilla.notification.Client;

import java.util.HashSet;
import java.util.Set;

public class Location {
    private String name;
    private Set<Client> subscribers = new HashSet<>();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Client client) {
        this.subscribers.add(client);
    }

    public void removeSubscriber(Client client) {
        this.subscribers.remove(client);
    }

    public Set<Client> getSubscribers() {
        return subscribers;
    }
}
