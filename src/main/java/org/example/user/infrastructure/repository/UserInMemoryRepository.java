package org.example.user.infrastructure.repository;

import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserInMemoryRepository implements UserRepository {

    List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
