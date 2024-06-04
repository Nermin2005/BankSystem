package entities;

import enums.PersonType;

public class User {
    private String username;
    private String password;
    private PersonType role;

    public User(String username, String password, PersonType role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(PersonType role) {
        this.role = role;
    }

    public PersonType getRole() {
        return role;
    }
}
