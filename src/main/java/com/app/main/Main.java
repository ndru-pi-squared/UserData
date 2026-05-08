package com.app.main;

import com.app.controller.AppController;

//entry point main class to run the application
public class Main {

    public static void main (String[] args){
        System.out.println("Hello, world2!");
        AppController appController = new AppController(10);
        appController.run();
    }
}
