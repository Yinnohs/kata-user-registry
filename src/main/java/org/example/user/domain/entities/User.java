package org.example.user.domain.entities;

import org.example.user.domain.exceptions.IncorrectCredentialsException;

public class User {
    String id;
    String email;
    String password;

    public User(String id, String email, String password) {
        if (!isCorrectPassword(password)){
            throw new IncorrectCredentialsException("Invalid Credentials");
        }
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private boolean isCorrectPassword(String password){
        String expectedPasswordPattern = "[A-Za-z0-9]";
        return  password.matches(expectedPasswordPattern);
    }
}
