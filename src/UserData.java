//import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserData {

    //logging stuff
    static LocalDateTime sessionInit;
    private static final Logger logger = Logger.getLogger(UserData.class.getName());

    //user data
    //static String input = "";
    static String userName = "";
    static String userMood = "";
    static User user;
    public record User(String userName, String userMood) {

        @Override
        public String toString() {
            return "username=" + userName + "\n" +
                "mood=" + userMood + "\n";
        }
        
        public String toFileFormat(){
            return "\"username\":\"" + userName + "\"\n" +
                "\"mood\":\"" + userMood + "\"\n";
        }

    }
    //program flow stuff
    public enum Command {
        EXIT,
        HELP,
        CONTINUE
    }

    public static void main (String[] args){
        logger.info("yo whats up");
        sessionInit = LocalDateTime.now();
        
        boolean running = true;
        System.out.println("Hi!");
        try( Scanner sc = new Scanner(System.in)){
            
            logEvent(Path.of("data/log.txt"), "User initiated session at " + sessionInit  +"\n");
            while(running){
                running = promptUserForName(sc);
                if(!running){
                    logEvent(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n"); 
                    return;
                }
                running = promptUserForMood(sc);
                if(!running){
                    logEvent(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n"); 
                    return;
                }
                user = createUserRecord(userName, userMood);
                logEvent(Path.of("data/log.txt"), "Account " + user.userName + " created at " + LocalDateTime.now()  +"\n");
                writeAccountToFile(Path.of("data/account.txt"), user.toFileFormat(), false);
                break;
                //running = false;
            }   
        sc.close();
        } //try
    
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        //if(systemTerminatedSession){
        logEvent(Path.of("data/log.txt"), "System terminated session at " + LocalDateTime.now()  +"\n");
        //}
        
    }//main

    public static Command parseInput(String input){

        return switch (input.trim().toLowerCase()) {
            case "exit" -> Command.EXIT;
            case "help" -> Command.HELP;
            default -> Command.CONTINUE;
        };
    }

    static void setName(String name){
        userName = name;
    }

    static void setMood(String mood){
        userMood = mood;
    }
    public static boolean promptUserForName(Scanner sc){
        System.out.println("Can I get your name?");
        String input = sc.nextLine();
        Command c = parseInput(input);
        switch (c){
            case Command.EXIT -> {return false;}
            case Command.HELP -> System.out.println("Available commands: exit, help");
            case Command.CONTINUE -> setName(input);//this is valid user data
        }
        logEvent(Path.of("data/log.txt"), "User entered input \"" + input + "\" into userName at " + LocalDateTime.now() + "\n");
        System.out.println("Hi,  " + userName + ". It's really nice to meet you.");
        return true;
    }

    public static boolean promptUserForMood(Scanner sc){
        System.out.println("How are you today?");
        String input = sc.nextLine();
        Command c = parseInput(input);
        switch (c){
            case Command.EXIT -> {return false;}
            case Command.HELP -> System.out.println("Available commands: exit, help");
            case Command.CONTINUE -> setMood(input);//this is valid user data
        }
        logEvent(Path.of("data/log.txt"), "User entered input \"" + input + "\" into userMood at " + LocalDateTime.now() + "\n");
        System.out.println("You're " + userMood + "? It's really interesting you say that because I feel the same way.");
        return true;
    }

    public static void logEvent(Path file, String event){
        try {
            Files.writeString(file, event, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public static void writeAccountToFile(Path file, String accountData, boolean append){
        try {
            Files.writeString(file, accountData, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public static User createUserRecord(String name, String mood){
        return new User(name, mood);
    }
    
}//class