package org.example.user.domain.entities;

import org.example.user.domain.vo.Email;
import org.example.user.domain.vo.Password;
import org.example.user.domain.vo.UserId;


public class User {
    UserId id;
    Email email;
    Password password;

    public User(String id, String email, String password) {
        this.id = new UserId(id);
        this.email = new Email(email);
        this.password = new Password(password);
    }

    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
