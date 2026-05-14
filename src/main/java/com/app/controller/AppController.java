package com.app.controller;

//owns application flow, the "program director"

import java.time.LocalDateTime;

import com.app.event.SessionCreatedEvent;
import com.app.event.SessionCreatedEventListener;
import com.app.logging.LoggerService;
import com.app.session.Session;
import com.app.session.SessionFactory;
//import com.app.event.SessionCreatedEvent;
//import com.app.logging.LogEvent;
//import com.app.logging.LogLevel;

public class AppController {
    
    boolean running;
    @SuppressWarnings("unused")
    private final LoggerService loggerService;
    private final SessionCreatedEventListener sessionCreatedEventListener;

    public AppController(){
        loggerService = new LoggerService();
        sessionCreatedEventListener = new SessionCreatedEventListener(loggerService);
    }

    public void run(){
        running = true;
        //TODO: wrap the following two lines in an event dispatcher
        Session userSession = SessionFactory.createUserSession(LocalDateTime.now(), "userID", "role");
        SessionCreatedEvent sessionCreatedEvent = userSession.toSessionCreatedEvent();//take a snapshot of the session created
        sessionCreatedEventListener.onEvent(sessionCreatedEvent);//log the session creation
        while(running){
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