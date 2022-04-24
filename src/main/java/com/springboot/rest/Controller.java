package com.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

        @GetMapping(value = "/")
        public String getPage(){
            return "Welcome";
        }

        @GetMapping(value = "/employees")
        public List<Employee> getEmployee(){
            return userRepository.findAll() ;
        }

        @PostMapping(value = "/save")
        public String saveEmployee(@RequestBody Employee employee){
            userRepository.save(employee);
            return "Employee Detail Saved to Database Successfully...."; }

        @PutMapping(value = "/update/{id}")
        public String updateEmployee(@PathVariable long id,@RequestBody Employee employee){
            Employee updateEmployee=userRepository.findById(id).get();
            updateEmployee.setFirstname(employee.getFirstname());
            updateEmployee.setLastname(employee.getLastname());
            updateEmployee.setAge(employee.getAge());
            updateEmployee.setDesignation(employee.getDesignation());
            userRepository.save(updateEmployee);
            return "Updated Successfully";
         }

         @DeleteMapping(value = "/delete/{id}")
        public String deleteEmployee(@PathVariable long id){
             Employee deleteEmployee=userRepository.findById(id).get();
             userRepository.delete(deleteEmployee);
             return "Employee details deleted...";
        }



}
