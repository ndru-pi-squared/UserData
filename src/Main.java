//entry point main class to run the application

//package com.app.main;

public class Main {

    public static void main (String[] args){
        AppController appController = new AppController(10);
        appController.run();
    }
}
