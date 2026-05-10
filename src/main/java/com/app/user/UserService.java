package com.app.user;

//service class to handle user related operations
public class UserService {

    public User createUser(String name, String mood) {
        return new User(name, mood);
    }

    public void run(){
       User user = createUser("Alice", "Happy");
       System.out.println("Created user: " + user);
    }
}