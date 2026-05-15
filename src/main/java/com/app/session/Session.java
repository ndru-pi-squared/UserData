package com.app.session;

//session interface to represent a generic session in the system, will be implemented by specific session classes to represent different types of sessions that can occur in the system

import java.time.LocalDateTime;


public interface Session {
    LocalDateTime getStartTime();
    boolean isActive();
    //SessionCreatedEvent toSessionCreatedEvent(); //handled in event snapshotter class to decouple
    SessionType getSessionType();
}