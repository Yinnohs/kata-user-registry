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
        boolean hasCharacters = passwordContainsCharacters(password);
        boolean hasNumbers = passwordContainsNumber(password);
        return  hasCharacters && hasNumbers;
    }

    private boolean passwordContainsNumber(String password){
        String pattern = "[\\d]";
        return password.matches(pattern);
    }

    private boolean passwordContainsCharacters(String password){

        String pattern = "[\\s]";
        return password.matches(pattern);
    }
}
