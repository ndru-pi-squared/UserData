package com.app.controller;

//owns application flow, the "program director"

import java.time.LocalDateTime;

import com.app.logging.LogEvent;
import com.app.logging.LogLevel;
import com.app.logging.LoggerService;

public class AppController {
    
    boolean running;
    LoggerService loggerService;

    
    public AppController(){
        loggerService = new LoggerService();
    }

    public void run(){
        running = true;
        while(running){
            loggerService.logEvent(new LogEvent(LocalDateTime.now(), LogLevel.INFO, "Session initiated"));
            break; //to prevent infinite loop for now, will add actual flow control later
        }
        //logging events
        //loggerService.logEvent(new LogEvent(LocalDateTime.now(), LogLevel.INFO, "Session terminated by user"));
        //loggerService.logEvent(new LogEvent(LocalDateTime.now(), LogLevel.INFO, "Session terminated by system"));
        //loggerService.logEvent(new LogEvent(LocalDateTime.now(), LogLevel.INFO, "Account " + userName + " created"));
        //loggerService.logEvent(new LogEvent(LocalDateTime.now(), LogLevel.INFO, "User entered input " + input + " into userName field in account creation form"));
        //loggerService.logEvent(new LogEvent(LocalDateTime.now(), LogLevel.INFO, "User entered input " + input + " into userMood field in account creation form"));

        //account io
        //writeAccountToFile(Path.of("data/account.txt"), user.toFileFormat(), false);
    }
}