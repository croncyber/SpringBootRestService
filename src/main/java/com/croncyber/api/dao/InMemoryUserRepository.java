package com.croncyber.api.dao;

import com.croncyber.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final List<User> userList = new ArrayList<>();

    @Override
    public Collection<User> getAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        int userId = userList.size() + 1;
        user.setId(userId);
        userList.add(user);
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userList.stream()
                       .filter(user -> user.getId() == id)
                       .findAny();
    }
}
