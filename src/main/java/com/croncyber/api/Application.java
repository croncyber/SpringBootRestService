package com.croncyber.api;

import com.croncyber.api.model.Department;
import com.croncyber.api.model.User;
import com.croncyber.api.repository.DepartmentJpaRepository;
import com.croncyber.api.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;


@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner init(UserRepository userRepository) {
//        return args -> {
//            log.info("Loading users into database...");
//            List.of(new User(1, "Potc", "Petrosyan"),
//                    new User(2, "Gotc", "Shwarc"),
//                    new User(3, "Dotc", "Churka"))
//                .forEach(user -> userRepository.save(user));
//            log.info("Users have been loaded.");
//        };
//    }

    @Bean
    public CommandLineRunner init(UserJpaRepository userJpaRepository, DepartmentJpaRepository departmentJpaRepository) {
        return (args) -> {
            // init user repository
            // save a few users
            log.info("Loading users into database...");
            userJpaRepository.save(new User(1L, "Potc", "Petrosyan"));
            userJpaRepository.save(new User(2L, "Gotc", "Shwarc"));
            userJpaRepository.save(new User(3L, "Dotc", "Churka"));
            log.info("Users have been loaded.");
            // fetch all users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : userJpaRepository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual user by ID
            Optional<User> user = userJpaRepository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");

            // fetch user by last name
            log.info("User found with findByLastName('Petrosyan'):");
            log.info("--------------------------------------------");
            userJpaRepository.findByLastName("Petrosyan").forEach(lastName -> {
                log.info(lastName.toString());
            });
//           for (User lastName : userJpaRepository.findByLastName("Petrosyan")) {
//            log.info(lastName.toString());
//           }
            log.info("");


            // init department repository
            // save a few departments
            log.info("Loading departments into database...");
            departmentJpaRepository.save(new Department("Comedy"));
            departmentJpaRepository.save(new Department("Entertainment"));
            departmentJpaRepository.save(new Department("Sport"));
            log.info("Departments have been loaded.");
            // fetch all departments
            log.info("Departments found with findAll():");
            log.info("-------------------------------");
            for (Department department : departmentJpaRepository.findAll()) {
                log.info(department.toString());
            }
            log.info("");

            // fetch an individual department by ID
            Department department = departmentJpaRepository.findById(4L);
            log.info("Department found with findById(1L):");
            log.info("--------------------------------");
            log.info(department.toString());
            log.info("");

            // fetch department by  name
            log.info("Department found with name('Comedy'):");
            log.info("--------------------------------------------");
            departmentJpaRepository.findByName("Comedy").forEach(name -> {
                log.info(name.toString());
            });
//           for (Department comedy : departmentJpaRepository.findByName("Comedy")) {
//              log.info(comedy.toString());
//          }
            log.info("");

        };
    }
}



