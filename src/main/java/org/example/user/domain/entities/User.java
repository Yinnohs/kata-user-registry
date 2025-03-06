package org.example.user.domain.entities;

import org.example.user.domain.exceptions.IncorrectCredentialsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        boolean hasUnderScore = passwordContainsUnderscore(password);
        return  hasCharacters && hasNumbers && hasUnderScore;
    }

    private boolean passwordContainsNumber(String password){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean passwordContainsCharacters(String password){
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean passwordContainsUnderscore(String password){
        Pattern pattern = Pattern.compile("_+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
