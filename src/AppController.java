//owns application flow, the "program director"

//package com.app.controller;

public class AppController {
    
    int x; //just for example
    
    public AppController(int y){
        x = y;    
    }

    public void run(){
        System.out.println("Running app controller with x = " + x);
    }
}