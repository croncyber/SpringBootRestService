package com.croncyber.api.controller;

import com.croncyber.api.dao.UsersDAO;
import com.croncyber.api.model.User;
import com.croncyber.api.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UsersDAO usersDAO;

    public UserController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping(path="/", produces = "application/json")
    public Users getUsers() {
        return usersDAO.getAllUsers();
    }

    @PostMapping (path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        //Generate resource id
        Integer id = usersDAO.getAllUsers().getUserList().size() + 1;
        user.setId(id);

        //add resource
        usersDAO.addUser(user);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
