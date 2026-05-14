package com.app.session;

import java.time.LocalDateTime;

import com.app.event.SessionCreatedEvent;


//user session class to represent a user session in the system, will be used to track user activity and manage session state
public class UserSession implements Session { 

    final private LocalDateTime sessionTimeInit;
    @SuppressWarnings({"FieldMayBeFinal", "unused"})
    private LocalDateTime inactiveTimeInit;//placeholder to track when user becomes inactive, will be used to determine when to terminate session after inactivity threshold is reached

    @SuppressWarnings("unused")
    final private String userID; 
    @SuppressWarnings("unused")
    final private String role; 
    private SessionState sessionState; //placeholder to track session state, will be used to manage session lifecycle and determine when to log session termination events
    final private SessionType sessionType;
    
    public UserSession(LocalDateTime sessionTimeInit, String userID, String role){
        this.sessionTimeInit = sessionTimeInit;
        this.userID = userID;
        this.role = role;
        sessionState = SessionState.ACTIVE;
        sessionType = SessionType.USER;
    }

    @Override
    public SessionCreatedEvent toSessionCreatedEvent() {//TODO: this responsibility should be in an even mapper class
        return new SessionCreatedEvent(sessionTimeInit, userID, role, sessionType);
    }
    @Override
    public LocalDateTime getStartTime() {
        return sessionTimeInit;
    }

    public String getUserID() {
        return userID;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean isActive() {
        return sessionState == SessionState.ACTIVE;
    }

    public void activate() {
        sessionState = SessionState.ACTIVE;
    }

    public void deactivate() {
        sessionState = SessionState.INACTIVE;
    }

    public void run(){
        //for now, just print a message to console when session is initiated
        System.out.println("User session initiated");
    }
}