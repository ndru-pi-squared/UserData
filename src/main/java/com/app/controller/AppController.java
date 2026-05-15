package com.app.controller;

//owns application flow, the "program director"

import java.time.LocalDateTime;

import com.app.event.EventDispatcher;
import com.app.event.EventSnapshotter;
import com.app.event.SessionCreatedEvent;
import com.app.event.SessionCreatedEventListener;
import com.app.logging.LoggerService;
import com.app.session.SessionFactory;
import com.app.session.UserSession;
//import com.app.event.SessionCreatedEvent;
//import com.app.logging.LogEvent;
//import com.app.logging.LogLevel;

public class AppController {
    
    boolean running;
    private final LoggerService loggerService;
    private final SessionCreatedEventListener sessionCreatedEventListener;
    private final EventDispatcher eventDispatcher;
    private final EventSnapshotter eventSnapshotter;

    public AppController(){
        loggerService = new LoggerService();
        sessionCreatedEventListener = new SessionCreatedEventListener(loggerService);
        eventDispatcher = new EventDispatcher(sessionCreatedEventListener);
        eventSnapshotter = new EventSnapshotter();
    }

    public void run(){
        running = true;
        //TODO: wrap the following two lines in an event dispatcher
        UserSession userSession = SessionFactory.createUserSession(LocalDateTime.now(), "userID", "role");
        SessionCreatedEvent sessionCreatedEvent = eventSnapshotter.takeSnapshot(userSession);
        eventDispatcher.dispatch(sessionCreatedEvent);
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