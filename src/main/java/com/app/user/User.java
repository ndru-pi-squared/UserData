//user class to represent a user in the system

package com.app.user;

public class User {
    
    String name;
    String mood;
    
    public User(String uName, String uMood){
        name = uName;
        mood = uMood;    
    }

    @Override
    public String toString() {
        return "username=" + name + "\n" +
            "mood=" + mood + "\n";
    }

    public void run(){
        System.out.println("Running user with name = " + name + " and mood = " + mood);
    }
}