package com.kodilla.spring.basic.dependency_injection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleApplicationTest {

    @Mock
    private MessageService emailMessageService;

    @Mock
    private MessageService facebookMessageService;

    @InjectMocks
    private SimpleApplication application;

    @Captor
    private ArgumentCaptor<String> messageCaptor;

    @Captor
    private ArgumentCaptor<String> receiverCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSendMessageUsingEmailService() {
        // Given
        application = new SimpleApplication(emailMessageService);

        // When
        application.processMessage("Hello, Email!", "email@receiver.com");

        // Then
        verify(emailMessageService).send(messageCaptor.capture(), receiverCaptor.capture());
        assertEquals("Hello, Email!", messageCaptor.getValue());
        assertEquals("email@receiver.com", receiverCaptor.getValue());
    }

    @Test
    void shouldSendMessageUsingFacebookService() {
        // Given
        application = new SimpleApplication(facebookMessageService);

        // When
        application.processMessage("Hello, Facebook!", "facebook@receiver.com");

        // Then
        verify(facebookMessageService).send(messageCaptor.capture(), receiverCaptor.capture());
        assertEquals("Hello, Facebook!", messageCaptor.getValue());
        assertEquals("facebook@receiver.com", receiverCaptor.getValue());
    }

    @Test
    void shouldNotSendMessageWhenReceiverIsNull() {
        // Given
        application = new SimpleApplication(facebookMessageService);

        // When
        application.processMessage("Test message", null);

        // Then
        Mockito.verify(facebookMessageService, Mockito.never()).send(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void shouldNotSendMessageWhenReceiverIsEmpty() {
        // Given
        application = new SimpleApplication(facebookMessageService);

        // When
        application.processMessage("Test message", "");

        // Then
        Mockito.verify(facebookMessageService, Mockito.never()).send(Mockito.anyString(), Mockito.anyString());
    }
}