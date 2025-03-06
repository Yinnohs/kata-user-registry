package org.example.user.application.ports.out;

import org.example.user.domain.entities.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
}
