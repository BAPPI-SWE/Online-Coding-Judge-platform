package services;

import models.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public boolean register(String username, String password, String email) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        users.add(new User(username, password, email));
        return true;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
