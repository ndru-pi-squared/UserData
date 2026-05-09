package com.app.controller;

//owns application flow, the "program director"
public class AppController {
    
    int x; //just for example
    boolean running;
    
    public AppController(int y){
        x = y;    
    }

    public void run(){
        running = true;
        while(running){
            System.out.println("Running app controller with x = " + x);
            break; //to prevent infinite loop for now, will add actual flow control later
        }
    }
}