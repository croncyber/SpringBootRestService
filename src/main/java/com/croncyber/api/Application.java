package com.croncyber.api;

import com.croncyber.api.dao.UserRepository;
import com.croncyber.api.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            System.out.println("Loading users into database...");
            List.of(new User(1, "Potc", "Petrosyan"),
                    new User(2, "Gotc", "Shwarc"),
                    new User(3, "Dotc", "Churka"))
                .forEach(user -> userRepository.save(user));
            System.out.println("Users have been loaded.");
        };
    }
}
