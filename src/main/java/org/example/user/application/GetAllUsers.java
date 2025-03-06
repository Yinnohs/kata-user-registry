package org.example.user.application;

import org.example.user.application.ports.out.UserRepository;

public class GetAllUsers {
    private final UserRepository repository;

    public GetAllUsers(UserRepository repository) {
        this.repository = repository;
    }
}
