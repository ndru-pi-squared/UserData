package com.app.event;

import java.time.LocalDateTime;

import com.app.user.UserRole;

//event class to represent a session created event, will be used to log session creation events and trigger any necessary actions in response to session creation
public class SessionCreatedEvent implements Event {
    private final LocalDateTime sessionStartTime;
    private final String userID;
    private final UserRole role;

    public SessionCreatedEvent(LocalDateTime sessionStartTime, String userID, UserRole role){
        this.sessionStartTime = sessionStartTime;
        this.userID = userID;
        this.role = role;
    }

    public LocalDateTime getSessionStartTime() {
        return sessionStartTime;
    }
    
    public String getUserID() {
        return userID;
    }

    public UserRole getRole() {
        return role;
    }

}