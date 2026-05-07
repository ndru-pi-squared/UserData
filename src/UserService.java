//service class to handle user related operations

//package com.app.user;

class UserService {

    public User createUser(String name, String mood) {
        return new User(name, mood);
    }
}