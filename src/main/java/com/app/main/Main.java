package com.app.main;

import com.app.controller.AppController;
import com.app.user.UserRole;
//import com.app.logging.LogEvent;
//import com.app.logging.LogLevel;
//import com.app.logging.LoggerConfig;
//import com.app.logging.LoggerService;

//entry point main class to run the application
public class Main {

    public static void main (String[] args){
        System.out.println("Hello, world!");
        AppController appController = new AppController(UserRole.USER); //for now we just pass in a user role of USER, but in the future we can add authentication logic to determine the user role based on user input or other factors
        appController.run();
    }
}
