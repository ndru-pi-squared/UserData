package com.app.event;
//event snapshotter class to create snapshots of events at runtime and converting them to objects that can be dispatched to event listeners
//takes the raw data from the session and passes it to the object that will be dispatched to the event listeners, 


import com.app.session.UserSession;
//import com.app.session.SessionType;
//import java.time.LocalDateTime;

//this allows us to decouple the session from the event system and allows for more flexible event handling in the system

public class EventSnapshotter {

    public SessionCreatedEvent toUserSessionCreatedEvent(UserSession userSession) { 
        return new SessionCreatedEvent(userSession.getStartTime(), userSession.getUserID(), userSession.getRole(), userSession.getSessionType());
    }

    //public SessionCreatedEvent toGuestSessionCreatedEvent(GuestSession guestSession) { //for example
        //return new SessionCreatedEvent(guestSession.getStartTime(), guestSession.getUserID(), guestSession.getRole(), guestSession.getSessionType());
    //}
}   