package org.example.user.domain.vo;

import org.example.user.domain.exceptions.IncorrectCredentialsException;

public class Email {
    private final String value;

    public Email(String value){
        if (!isCorrectEmail(value)){
            throw new IncorrectCredentialsException("Invalid Credentials");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isCorrectEmail(String email){
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(pattern);
    }
}
