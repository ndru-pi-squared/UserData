package com.app.event;

import java.time.LocalDateTime;

//event class to represent a session created event, will be used to log session creation events and trigger any necessary actions in response to session creation
public class SessionCreatedEvent implements Event {
    public LocalDateTime sessionTimeInit;
    public String userID;
    public String role;

    public SessionCreatedEvent(LocalDateTime sessionTimeInit, String userID, String role){
        this.sessionTimeInit = sessionTimeInit;
        this.userID = userID;
        this.role = role;
    }
}