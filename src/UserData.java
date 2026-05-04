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
    static String input = "";
    static String userName = "";
    static String userMood = "";
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
        

        System.out.println("Hi!");
        try( Scanner sc = new Scanner(System.in)){
            
            Files.writeString(Path.of("data/log.txt"), "User initiated session at " + sessionInit  +"\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            //fw.write("User initiated session at " + sessionInit);
            System.out.println("Can I get your name?");
            
            input = sc.nextLine(); 

            switch(input){
                case "exit" ->{
                    Files.writeString(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Session terminated. Goodbye!");
                    return;
                }
                    
                case "help"->{
                    Files.writeString(Path.of("data/log.txt"), "User asked for help at " + LocalDateTime.now() + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Available commands: exit, help");
                }
                default->{
                    userName = input;
                    Files.writeString(Path.of("data/log.txt"), "User entered input \"" + userName + "\" at " + LocalDateTime.now() + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Hi,  " + userName + ". It's really nice to meet you.");
                }
                    
            }
            
            System.out.println("How are you today?");
            userMood = sc.nextLine();
            Files.writeString(Path.of("data/log.txt"), "User entered input \"" + userMood + "\" at " + LocalDateTime.now() + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            //user entered mood xxx
            System.out.println("You're " + userMood + "? It's really interesting you say that because I feel the same way.");
            User user = createUser(userName, userMood);
            //Files.writeString(Path.of("account.txt"), "Name: " + user.toString(), StandardOpenOption.CREATE);
            logEvent(Path.of("data/account.txt"), user.toFileFormat(), false);
            Files.writeString(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } 
    
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
        //log session terminated
        
    }//main

    public static String readInput(Scanner sc){

        return "";
    }

    public static Command parseCommand(String input){

        return switch (input.trim().toLowerCase()) {
            case "exit" -> Command.EXIT;
            case "help" -> Command.HELP;
            default -> Command.CONTINUE;
        };
    }

    public static void logEvent(Path file, String event, boolean append){
        try {
            if(append){
                Files.writeString(file, "Name: " + event, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            }
            else{
                Files.writeString(file, "Name: " + event, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public static User createUser(String name, String mood){
        return new User(name, mood);
    }

    





    
}//class