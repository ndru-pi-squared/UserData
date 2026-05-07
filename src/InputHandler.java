//talks to the user, displays prompts, reads input

//package com.app.input;

public class InputHandler {
    
    int x; //just for example
    
    public InputHandler(int y){
        x = y;    
    }

    public void run(){
        System.out.println("Running input handler with x = " + x);
    }
}