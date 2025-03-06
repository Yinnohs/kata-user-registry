package org.example.user.application;

import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;

public class RegisterUser {
    private final UserRepository repository;

    public RegisterUser(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(String email, String password) {
        return null;
    }
}

