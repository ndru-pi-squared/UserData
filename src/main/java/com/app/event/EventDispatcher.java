package com.app.event;

//event dispatcher class to manage event dispatching and listener registration, will be used to decouple event producers and consumers and allow for more flexible event handling in the system

public class EventDispatcher {

    private final SessionCreatedEventListener sessionCreatedEventListener;

    public EventDispatcher(SessionCreatedEventListener listener){
        this.sessionCreatedEventListener = listener;
    }

    //so it needs a session, a sessioncreated event, and a listener. 
    //it should own the listener
    public void dispatch(SessionCreatedEvent sessionCreatedEvent){
        //SessionCreatedEvent sessionCreatedEvent = session.toSessionCreatedEvent();//take a snapshot of the session created
        sessionCreatedEventListener.onEvent(sessionCreatedEvent);//log the session creation
    }
}