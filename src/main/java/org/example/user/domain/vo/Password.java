package org.example.user.domain.vo;

import org.example.user.domain.exceptions.IncorrectCredentialsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private final String value;

    public Password(String value){
        if (!isCorrectPassword(value)){
            throw new IncorrectCredentialsException("Invalid Credentials");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isCorrectPassword(String password){
        boolean hasCharacters = passwordContainsCharacters(password);
        boolean hasNumbers = passwordContainsNumber(password);
        boolean hasUnderScore = passwordContainsUnderscore(password);
        boolean hasEightCharactersOrMore = passwordShouldContainAtLeastEightCharacters(password);

        return  hasCharacters && hasNumbers && hasUnderScore && hasEightCharactersOrMore;
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

    private boolean passwordShouldContainAtLeastEightCharacters(String password){
        int expectedPasswordLength = 8;
        return  password.length() >= expectedPasswordLength;
    }
}
