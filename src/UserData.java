//import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserData {

//TODO
//record the field in which the user was typing when writing to log in readInput()
//handle clean exit by properly cleaning up when user types "exit" instead of simply calling System.exit
//add while(running) loop? perhaps have readInput return boolean and input pair?
    //logging stuff
    static LocalDateTime sessionInit;
    private static final Logger logger = Logger.getLogger(UserData.class.getName());

    //user data
    static String input = "";
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
        

        System.out.println("Hi!");
        try( Scanner sc = new Scanner(System.in)){
            
            logEvent(Path.of("data/log.txt"), "User initiated session at " + sessionInit  +"\n", true);
            getName(sc);
            getMood(sc);

            user = createUserRecord(userName, userMood);
            writeAccountToFile(Path.of("data/account.txt"), user.toFileFormat(), false);


            //Files.writeString(Path.of("data/log.txt"), "User initiated session at " + sessionInit  +"\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            //fw.write("User initiated session at " + sessionInit);
            
            //System.out.println("Can I get your name?");
            //userName = readInput(sc);
            //logEvent(Path.of("data/log.txt"), "User entered input \"" + userName + "\" at " + LocalDateTime.now() + "\n", true);
            //System.out.println("Hi,  " + userName + ". It's really nice to meet you.");
            /*input = sc.nextLine(); 

            switch(input){
                case "exit" ->{
                    logEvent(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n", true);
                    //Files.writeString(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Session terminated. Goodbye!");
                    return;
                }
                    
                case "help"->{
                    logEvent(Path.of("data/log.txt"), "User asked for help at " + LocalDateTime.now() + "\n", true);
                    //Files.writeString(Path.of("data/log.txt"), "User asked for help at " + LocalDateTime.now() + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Available commands: exit, help");
                }
                default->{
                    userName = input;
                    logEvent(Path.of("data/log.txt"), "User entered input \"" + userName + "\" at " + LocalDateTime.now() + "\n", true);
                    //Files.writeString(Path.of("data/log.txt"), "User entered input \"" + userName + "\" at " + LocalDateTime.now() + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Hi,  " + userName + ". It's really nice to meet you.");
                }
                    
            }
            
            System.out.println("How are you today?");
            input = sc.nextLine(); 

            switch(input){
                case "exit" ->{
                    logEvent(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n", true);
                    
                    System.out.println("Session terminated. Goodbye!");
                    return;
                }
                    
                case "help"->{
                    logEvent(Path.of("data/log.txt"), "User asked for help at " + LocalDateTime.now() + "\n", true);
                    
                    System.out.println("Available commands: exit, help");
                }
                default->{
                    userMood = input;
                    logEvent(Path.of("data/log.txt"), "User entered input \"" + userMood + "\" at " + LocalDateTime.now() + "\n", true);
                    
                    System.out.println("You're " + userMood + "? It's really interesting you say that because I feel the same way.");
                }
                    
            }*/
            
        } 
    
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        logEvent(Path.of("data/log.txt"), "System terminated session at " + LocalDateTime.now()  +"\n", true);    
    }//main

    public static String readInput(Scanner sc){
        input = sc.nextLine(); 

            switch(input){
                case "exit" ->{
                    logEvent(Path.of("data/log.txt"), "User terminated session at " + LocalDateTime.now()  +"\n", true);
                    
                    System.out.println("Session terminated. Goodbye!");
                    sc.close();
                    System.exit(0);
                    //return null;
                }
                    
                case "help"->{
                    logEvent(Path.of("data/log.txt"), "User asked for help at " + LocalDateTime.now() + "\n", true);
                    
                    System.out.println("Available commands: exit, help");
                }
                default->{
                    //userMood = input;
                    logEvent(Path.of("data/log.txt"), "User entered input \"" + input + "\" at " + LocalDateTime.now() + "\n", true);
                    
                    //System.out.println("You're " + userMood + "? It's really interesting you say that because I feel the same way.");
                }
                    
            }

        return input;
    }

    public static void getName(Scanner sc){
        System.out.println("Can I get your name?");
        userName = readInput(sc);
        //logEvent(Path.of("data/log.txt"), "User entered input \"" + userName + "\" into userName at " + LocalDateTime.now() + "\n", true);
        System.out.println("Hi,  " + userName + ". It's really nice to meet you.");
    }

    public static void getMood(Scanner sc){
        System.out.println("How are you today?");
        userMood = readInput(sc);
        //logEvent(Path.of("data/log.txt"), "User entered input \"" + userName + "\" into userMood at " + LocalDateTime.now() + "\n", true);
        System.out.println("You're " + userMood + "? It's really interesting you say that because I feel the same way.");
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
            if(append){ //if we're adding new data, writing to log.txt
                Files.writeString(file, "Name: " + event, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            }
            else{ //if we're overwriting existing data, previously writing to acccount.txt
                //Files.writeString(file, "Name: " + event, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public static void writeAccountToFile(Path file, String event, boolean append){
        try {
            logEvent(Path.of("data/log.txt"), "Account " + user.userName + " created at " + LocalDateTime.now()  +"\n", true);
            if(append){ //if we're adding new data
                Files.writeString(file, "Name: " + event, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            }
            else{ //if we're overwriting existing data
                Files.writeString(file, "Name: " + event, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } 
        catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    public static User createUserRecord(String name, String mood){
        return new User(name, mood);
    }

    





    
}//class