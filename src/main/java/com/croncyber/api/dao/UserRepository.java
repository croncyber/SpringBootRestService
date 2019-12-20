package com.croncyber.api.dao;

import com.croncyber.api.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {
    Collection<User> getAll();

    void save(User user);

    Optional<User> getById(Integer id);
}
