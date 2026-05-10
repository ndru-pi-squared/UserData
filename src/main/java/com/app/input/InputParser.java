package com.app.input;

//parses user input and commands, and calls appropriate services to handle them
public class InputParser {
    
    int x; //just for example
    
    public InputParser(int y){
        x = y;    
    }

    public enum Command {
        EXIT,
        HELP,
        CONTINUE
    }
    
    public static Command parseInput(String input){

        return switch (input.trim().toLowerCase()) {
            case "exit" -> Command.EXIT;
            case "help" -> Command.HELP;
            default -> Command.CONTINUE;
        };
    }

    public void run(){
        System.out.println("Running input parser with x = " + x);
    }
}