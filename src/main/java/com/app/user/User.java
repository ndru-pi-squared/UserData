package com.app.user;

//user class to represent a user in the system
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

    void setName(String uName){
        name = uName;
    }

    void setMood(String uMood){
        mood = uMood;
    }

    String getName(){
        return name;
    }

    String getMood(){
        return mood;
    }

    

    public void run(){
        System.out.println("Running user with name = " + name + " and mood = " + mood);
    }
}