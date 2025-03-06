package org.example.user.infrastructure.controller;

import org.example.user.application.GetAllUsers;
import org.example.user.application.RegisterUser;
import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;

public class UserController {

    private final GetAllUsers getAllUsersUseCase;
    private final RegisterUser registerUserUseCase;

    public UserController(GetAllUsers getAllUsersUseCase, RegisterUser registerUserUseCase) {
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    public User registerUser(String email, String password){
        return registerUserUseCase.execute(email, password);
    }
}
