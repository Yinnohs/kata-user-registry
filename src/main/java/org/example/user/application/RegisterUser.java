package org.example.user.application;

import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;

import java.util.UUID;

public class RegisterUser {
    private final UserRepository repository;

    public RegisterUser(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(String email, String password) {
        var userId = UUID.randomUUID().toString();
        var newUser = new User(userId, email, password);
        return repository.save(newUser);
    }
}

