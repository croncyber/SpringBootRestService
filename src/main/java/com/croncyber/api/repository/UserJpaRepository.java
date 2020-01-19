package com.croncyber.api.repository;

import com.croncyber.api.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);

    Optional<User> findById(Long id);
}
