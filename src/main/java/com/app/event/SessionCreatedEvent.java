package com.app.event;

import java.time.LocalDateTime;

import com.app.session.SessionType;

//event class to represent a session created event, will be used to log session creation events and trigger any necessary actions in response to session creation
public class SessionCreatedEvent implements Event {
    private final LocalDateTime sessionTimeInit;
    private final String userID;
    private final String role;
    private final SessionType sessionType;

    public SessionCreatedEvent(LocalDateTime sessionTimeInit, String userID, String role, SessionType sessionType){
        this.sessionTimeInit = sessionTimeInit;
        this.userID = userID;
        this.role = role;
        this.sessionType = sessionType;
    }

    public LocalDateTime getSessionTimeInit() {
        return sessionTimeInit;
    }
    
    public String getUserID() {
        return userID;
    }

    public String getRole() {
        return role;
    }

    public SessionType getSessionType() {
        return sessionType;
    }
}