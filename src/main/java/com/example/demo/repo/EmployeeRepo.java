package com.example.demo.repo;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//to be able to use JPA methods like save ,...
//we can also do queries manually if necessary
public interface EmployeeRepo extends JpaRepository<Employee/*The class*/,Long/*The id type*/> {



    //this is a query method in spring we had to create because JPA doesn't have it by default that deletes employee by ID using JPA
    void deleteEmployeeById(Long id);

    //we did this one Optional instead of Employee because sometimes we Employee won't exist
    Optional<Employee> findEmployeeById(Long id);
}
