package com.app.event;

import com.app.logging.LogEvent;
import com.app.logging.LogLevel;
import com.app.logging.LoggerService;

//event listener class to handle session created events, will be registered with the event dispatcher to receive notifications when a session created event occurs and perform necessary actions in response to the event
public class SessionCreatedEventListener implements EventListener<SessionCreatedEvent> {
    LoggerService loggerService;

    public SessionCreatedEventListener(LoggerService loggerService){
        this.loggerService = loggerService;
    }
    
    @Override
    public void onEvent(SessionCreatedEvent event) {
        // Handle session created event
        loggerService.logEvent(new LogEvent(event.getSessionStartTime(), LogLevel.INFO, event.getRole().toString() +" session initiated"));
    }
}