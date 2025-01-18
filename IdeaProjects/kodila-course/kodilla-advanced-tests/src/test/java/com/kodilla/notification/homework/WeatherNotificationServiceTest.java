package com.kodilla.notification.homework;

import com.kodilla.notification.Client;
import com.kodilla.notification.Notification;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class WeatherNotificationServiceTest {

    WeatherNotificationService weatherNotificationService = new WeatherNotificationService();
    Client client = Mockito.mock(Client.class);
    Client secondClient = Mockito.mock(Client.class);
    Client thirdClient = Mockito.mock(Client.class);
    Location location = new Location("Kraków");
    Location secondLocation = new Location("Warszawa");
    Notification notification = new WeatherNotification("Zagrożenie gradem");

    @Test
    public void notSubscribedClientShouldNotReceiveLocationNotification() {
        weatherNotificationService.sendNotificationToLocation(notification, location);
        verify(client, never()).receive(notification);
    }

    @Test
    public void subscribedClientShouldReceiveLocationNotification() {
        weatherNotificationService.addSubscriberToLocation(client, location);

        weatherNotificationService.sendNotificationToLocation(notification, location);

        verify(client).receive(notification);
    }

    @Test
    public void notificationShouldBeSentToAllClients() {
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(secondClient, secondLocation);
        weatherNotificationService.addSubscriberToLocation(thirdClient, location);

        weatherNotificationService.sendNotificationToAll(notification);

        verify(client).receive(notification);
        verify(secondClient).receive(notification);
        verify(thirdClient).receive(notification);
    }

    @Test
    public void shouldSendOnlyOneNotificationToMultiTimeSubscriber() {
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(client, secondLocation);

        weatherNotificationService.sendNotificationToAll(notification);

        verify(client, times(1)).receive(notification);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveLocationNotification() {
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.removeSubscriberFromLocation(client, location);

        weatherNotificationService.sendNotificationToLocation(notification, location);

        verify(client, never()).receive(notification);
    }

    @Test
    public void shouldRemoveClientFromAllLocations() {
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(client, secondLocation);

        weatherNotificationService.removeAllSubscriptions(client);

        weatherNotificationService.sendNotificationToLocation(notification, location);
        weatherNotificationService.sendNotificationToLocation(notification, secondLocation);

        verify(client, never()).receive(notification);
    }

    @Test
    public void shouldRemoveLocationAndItsSubscribers() {
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(secondClient, location);

        weatherNotificationService.removeLocation(location);

        weatherNotificationService.sendNotificationToLocation(notification, location);

        verify(client, never()).receive(notification);
        verify(secondClient, never()).receive(notification);
    }
}