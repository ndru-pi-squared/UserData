package com.app.user;

public class UserSerializer {


    //User user = createUser(name, mood)
    //string data = userSerializer.serialize(user)
    //userfilerepository.save(data)
    
    public String serialize(String userName, String userMood){
            return "\"username\":\"" + userName + "\"\n" +
                "\"mood\":\"" + userMood + "\"\n";
    }

    public void run(){
       System.out.println("User serializer running");
    }
}