package com.app.logging;

public class LogEvent {
    
    public String event;
    public LogLevel level;

    public LogEvent(String event, LogLevel level){
        this.event = event;
        this.level = level;
        //for now, just print the event to console with its level
        //System.out.println("[" + level + "] " + event);

    }

    public enum LogLevel {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }



}