package com.app.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEvent {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
    
    public String event;
    public LogLevel level;
    public LocalDateTime timestamp;

    public LogEvent(LocalDateTime timestamp, LogLevel level, String event){
        this.level = level;
        this.event = event;
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] [%s] %s", timestamp.format(formatter), level, event);
    }



}