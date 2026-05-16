package com.app.event;

import java.time.LocalDateTime;

import com.app.user.UserRole;

//event class to represent a session created event, will be used to log session creation events and trigger any necessary actions in response to session creation
public class SessionCreatedEvent implements Event {
    private final LocalDateTime sessionTimeInit;
    private final String userID;
    private final UserRole role;

    public SessionCreatedEvent(LocalDateTime sessionTimeInit, String userID, UserRole role){
        this.sessionTimeInit = sessionTimeInit;
        this.userID = userID;
        this.role = role;
    }

    public LocalDateTime getSessionTimeInit() {
        return sessionTimeInit;
    }
    
    public String getUserID() {
        return userID;
    }

    public UserRole getRole() {
        return role;
    }

}