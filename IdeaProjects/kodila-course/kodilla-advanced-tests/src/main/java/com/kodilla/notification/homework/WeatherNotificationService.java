package com.kodilla.notification.homework;

import com.kodilla.notification.Client;
import com.kodilla.notification.Notification;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Flow;

public class WeatherNotificationService {

    private Set<Client> allClients = new HashSet<>();
    private Map<Location, Set<Client>> locationSubscribers = new HashMap<>();

    public void addSubscriberToLocation(Client client, Location location) {
        locationSubscribers
                .computeIfAbsent(location, k -> new HashSet<>())
                .add(client);
        allClients.add(client);
    }

    public void removeSubscriberFromLocation(Client client, Location location) {
        Set<Client> subscribers = locationSubscribers.get(location);
        if (subscribers != null) {
            subscribers.remove(client);
        }
    }

    public void removeAllSubscriptions(Client client) {
        locationSubscribers.values().forEach(subscribers -> subscribers.remove(client));
        allClients.remove(client);
    }

    public void removeLocation(Location location) {
        locationSubscribers.remove(location);
    }

    public void sendNotificationToAll(Notification notification) {
        allClients.forEach(client -> client.receive(notification));
    }

    public void sendNotificationToLocation(Notification notification, Location location) {
        Set<Client> subscribers = locationSubscribers.get(location);
        if (subscribers != null) {
            subscribers.forEach(client -> client.receive(notification));
        }
    }
}
