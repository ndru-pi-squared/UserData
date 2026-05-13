package com.app.session;

import java.time.LocalDateTime;
public class SessionCreatedEvent {
    public LocalDateTime sessionTimeInit;
    public String userID;
    public String role;

    public SessionCreatedEvent(LocalDateTime sessionTimeInit, String userID, String role){
        this.sessionTimeInit = sessionTimeInit;
        this.userID = userID;
        this.role = role;
    }
}