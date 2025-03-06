package org.example.user.infrastructure.repository;

import org.example.user.application.ports.out.UserRepository;
import org.example.user.domain.entities.User;

import java.util.List;

public class UserInMemoryRepository implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
