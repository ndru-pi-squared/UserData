package com.app.event;

//event listener interface to represent a generic event listener in the system, will be implemented by specific event listener classes to handle different types of events that can occur in the system
public interface EventListener<T> {
    void onEvent(T event);
}