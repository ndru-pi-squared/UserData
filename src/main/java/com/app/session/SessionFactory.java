package com.app.session;

import java.time.LocalDateTime;

import com.app.user.UserRole;

//session factory class to create different types of sessions in the system, will be used to centralize session creation logic and provide a single point of entry for creating sessions in the system
public class SessionFactory {

    public static UserSession createUserSession(LocalDateTime sessionInitTime, String userId, UserRole role) {
        return new UserSession(sessionInitTime, userId, role);
    }

    //public static Session createDatabaseSession(String connectionString) { //just for example, for now we only have one type of session but i just wanted to use a factory pattern here to demonstrate how we can use it to create different types of sessions in the future if needed
        //return new DatabaseSession(connectionString);
    //}
}