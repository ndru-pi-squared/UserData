package com.app.session;

import java.time.LocalDateTime;

import com.app.user.UserRole;


//user session class to represent a user session in the system, will be used to track user activity and manage session state
public class UserSession implements Session { 

    final private LocalDateTime sessionTimeInit;
    @SuppressWarnings({"FieldMayBeFinal", "unused"})
    private LocalDateTime inactiveTimeInit;//placeholder to track when user becomes inactive, will be used to determine when to terminate session after inactivity threshold is reached

    final private String userID; 
    final private UserRole role;
    private SessionState sessionState; //placeholder to track session state, will be used to manage session lifecycle and determine when to log session termination events
    
    
    public UserSession(LocalDateTime sessionTimeInit, String userID, UserRole role){
        this.sessionTimeInit = sessionTimeInit;
        this.userID = userID;
        this.role = role;
        sessionState = SessionState.ACTIVE;
    }

    /*@Override
    public SessionCreatedEvent toSessionCreatedEvent() {//handled in event snapshotter class to decouple
        return new SessionCreatedEvent(sessionTimeInit, userID, role, sessionType);
    }*/

    @Override
    public LocalDateTime getStartTime() {
        return sessionTimeInit;
    }

     @Override
    public boolean isActive() {
        return sessionState == SessionState.ACTIVE;
    }

    public UserRole getRole() {
        return role;
    }

    public String getUserID() {
        return userID;
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