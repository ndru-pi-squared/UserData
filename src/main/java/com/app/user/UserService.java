package com.app.user;

//service class to handle user related operations
public class UserService {

    public User createUser(String name, String mood) {
        return new User(name, mood);
    }

    //User user = createUser(name, mood)
    //string data = userSerializer.serialize(user)
    //userfilerepository.save(data)
    

    public void run(){
       User user = createUser("Alice", "Happy");
       System.out.println("Created user: " + user);
    }
}