package business.concretes;

import entities.User;
import enums.PersonType;

import java.util.HashMap;
import java.util.Map;

public class AuthControlManager {
    private Map<String, User> users;

    public AuthControlManager() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean authorize(User user, PersonType requiredRole) {
        return user.getRole().equals(requiredRole);
    }
}
