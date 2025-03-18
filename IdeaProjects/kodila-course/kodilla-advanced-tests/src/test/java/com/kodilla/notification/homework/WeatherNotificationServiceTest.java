package com.kodilla.notification.homework;

import com.kodilla.notification.Client;
import com.kodilla.notification.Notification;
import com.kodilla.notification.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherNotificationServiceTest {

    private WeatherNotificationService weatherNotificationService;
    private Client client;
    private Client secondClient;
    private Client thirdClient;
    private Notification notification;
    private Location location;
    private Location secondLocation;

    @BeforeEach
    public void setup() {
        weatherNotificationService = new WeatherNotificationService();
        NotificationService notificationService = new NotificationService();
        client = Mockito.mock(Client.class);
        secondClient = Mockito.mock(Client.class);
        thirdClient = Mockito.mock(Client.class);
        notification = Mockito.mock(Notification.class);
        location = new Location("Kraków");
        secondLocation = new Location("Warszawa");
    }

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
    @Test
    void shouldReturnCorrectMessage() {
        // Given
        String expectedMessage = "Today's weather is sunny.";
        WeatherNotification weatherNotification = new WeatherNotification(expectedMessage);

        // When
        String actualMessage = weatherNotification.getMessage();

        // Then
        assertEquals(expectedMessage, actualMessage);
    }
}