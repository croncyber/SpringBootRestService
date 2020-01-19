package com.croncyber.api.repository;

import com.croncyber.api.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentJpaRepository extends CrudRepository<Department, Long> {
    List<Department> findByName(String name);
    Department findById(long id);
}
