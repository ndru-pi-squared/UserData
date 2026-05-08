package com.app.controller;

//owns application flow, the "program director"
public class AppController {
    
    int x; //just for example
    
    public AppController(int y){
        x = y;    
    }

    public void run(){
        System.out.println("Running app controller with x = " + x);
    }
}