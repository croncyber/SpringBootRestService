package com.croncyber.api.dao;

import com.croncyber.api.model.User;
import com.croncyber.api.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO {
    private static Users list = new Users();

    static
    {
        list.getUserList().add(new User(1, "Potc", "Petrosyan"));
        list.getUserList().add(new User(2, "Gotc", "Shwarc"));
        list.getUserList().add(new User(3, "Dotc", "Churka"));
    }

    public Users getAllUsers()
    {
        return list;
    }

    public void addUser(User user) {
        list.getUserList().add(user);
    }



}
