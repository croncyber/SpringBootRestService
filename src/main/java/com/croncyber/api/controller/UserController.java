//package com.croncyber.api.controller;
//
//import com.croncyber.api.repository.UserRepository;
//import com.croncyber.api.model.User;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collection;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
//
//@RestController
//@RequestMapping(path = "/users",
//        produces = APPLICATION_JSON_UTF8_VALUE)
//public class UserController {
//    private final UserRepository userRepository;
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/all")
//    public Collection<User> getAll() {
//        return userRepository.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public User getByIdPath(@PathVariable("id") int id) {
//        return getUserById(id);
//    }
//
//    @GetMapping
//    public User getByIdParam(@RequestParam("userId") int id) {
//        return getUserById(id);
//    }
//
//    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
//    public void addUser(@RequestBody User user) {
//        userRepository.save(user);
//        System.out.println("User " + user + " has been saved");
//    }
//
//    private User getUserById(@RequestParam("userId") int id) {
//        if (id == 5){
//            throw new RuntimeException("Baba yagodka opat!!!");
//        }
//        return userRepository.getById(id)
//                             .orElseThrow(() -> new RuntimeException("Idi nahuy suka, net takogo usera!!!"));
//    }
//}
