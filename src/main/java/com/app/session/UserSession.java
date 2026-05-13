package com.app.session;

import java.time.LocalDateTime;

//user session class to represent a user session in the system, will be used to track user activity and manage session state
public class UserSession { 

    public LocalDateTime sessionTimeInit;
    public LocalDateTime inactiveTimeInit;//placeholder to track when user becomes inactive, will be used to determine when to terminate session after inactivity threshold is reached
    public boolean active;

    @SuppressWarnings("unused")
    String userID; 
    @SuppressWarnings("unused")
    String role; 
    //boolean isauthenticated
    
    public UserSession(LocalDateTime sessionTimeInit, String userID, String role){
        //for now, just print a message to console when session is initiated
        this.sessionTimeInit = sessionTimeInit;
        this.userID = userID;
        this.role = role;
        this.active = true;
        System.out.println("User session initiated");
    }
    
    public void run(){
        //for now, just print a message to console when session is initiated
        System.out.println("User session initiated");
    }
}