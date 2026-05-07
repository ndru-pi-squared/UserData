//service class to handle user related operations

class UserService {

    public User createUser(String name, String mood) {
        return new User(name, mood);
    }
}