package com.app.presentation;

//class to handle user interface related operations, such as displaying prompts, showing output, etc.
public class UIService {
    
    int x; //just for example
    
    public UIService(int y){
        x = y;    
    }

    public void run(){
        System.out.println("Running UI service with x = " + x);
    }

    //one idea is to have statements stored in a data structure and then display them based on an enum value passed to a method

    //System.out.println("Hi!");
    //prompt user for name
        //System.out.println("Can I get your name?");
        //input handler checks for input or commands (help/exit)
        //if input, setname
        //System.out.println("Hi,  " + userName + ". It's really nice to meet you.");
    //prompt user for mood
        //System.out.println("How are you today?");
        //input handler checks for input or commands (help/exit)
        //if input, setmood
        //System.out.println("You're " + userMood + "? It's really interesting you say that because I feel the same way.");
    //externally, create user record and write account to file with user data


}