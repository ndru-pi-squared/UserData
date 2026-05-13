package com.app.event;

//event listener class to handle session created events, will be registered with the event dispatcher to receive notifications when a session created event occurs and perform necessary actions in response to the event
public class SessionCreatedEventListener implements EventListener<SessionCreatedEvent> {
    @Override
    public void onEvent(SessionCreatedEvent event) {
        // Handle session created event
    }
}