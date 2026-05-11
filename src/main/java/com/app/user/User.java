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

    @SuppressWarnings("unused")//intentionally unused for now until integration
    void setName(String uName){
        name = uName;
    }

    @SuppressWarnings("unused")
    void setMood(String uMood){
        mood = uMood;
    }

    @SuppressWarnings("unused")
    String getName(){
        return name;
    }

    @SuppressWarnings("unused")
    String getMood(){
        return mood;
    }

    

    public void run(){
        System.out.println("Running user with name = " + name + " and mood = " + mood);
    }
}