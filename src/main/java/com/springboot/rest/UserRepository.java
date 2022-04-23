package com.springboot.rest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee,Long> {
    public  Employee findEmployeeByfirstname(String firstname);
}
