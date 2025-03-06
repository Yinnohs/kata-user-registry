package org.example.user.application;

import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;

import java.util.List;

public class GetAllUsers {
    private final UserRepository repository;

    public GetAllUsers(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
