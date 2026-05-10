package com.app.logging;

//service class to handle logging operations
public class LoggerService {

    public LoggerService(){
        //for now, just print a message to console when logger service is initialized
        System.out.println("Logger service initialized");
    }

    public void logEvent(LogEvent event){
        //for now, just print the event to console with its level
        System.out.println(event.toString());
    }

    public void run(){
        System.out.println("Running logger service");
        //logger.info("yo whats up");
    }
}

