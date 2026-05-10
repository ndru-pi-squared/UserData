package com.app.main;

import com.app.controller.AppController;
//import com.app.logging.LogEvent;
//import com.app.logging.LogLevel;
//import com.app.logging.LoggerConfig;
//import com.app.logging.LoggerService;

//entry point main class to run the application
public class Main {

    public static void main (String[] args){
        System.out.println("Hello, world!");
        AppController appController = new AppController(10);
        appController.run();
        //LoggerService loggerService = new LoggerService();
        //LogEvent event = new LogEvent(LocalDateTime.now(), LogLevel.INFO, "Application started");
        //loggerService.logEvent(event);
        //LoggerConfig loggerConfig = new LoggerConfig();
        //loggerConfig.run();
    }
}
