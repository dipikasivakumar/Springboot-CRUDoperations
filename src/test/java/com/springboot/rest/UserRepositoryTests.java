package com.springboot.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    @Rollback(false)
    public  void testCreateEmployee(){
        Employee e = new Employee(4,"Dipika","Sivakumar",24,"Engineer");
        Employee savedEmployee = userRepository.save(e);
        assertNotNull(savedEmployee );
    }

    @Test
    public void testfindEmployeebyFirstName(){
        String firstname= "Dipika";
        Employee e =userRepository.findEmployeeByfirstname(firstname);
        assertThat(e.getFirstname()).isEqualTo(firstname);
    }
    @Test

    public void testupdateEmployee(){
        String firstname="KLM";
        Employee employee = new Employee(2,firstname,"HIJ",21,"Engineer");
        userRepository.save(employee);
        Employee updatedEmployee = userRepository.findEmployeeByfirstname(firstname);
        assertThat(updatedEmployee.getFirstname()).isEqualTo(firstname);

    }
    @Test
    public void testDeleteEmployee() {
        long id = 3;
        boolean present1 = userRepository.findById(id).isPresent();
        userRepository.deleteById(id);
        boolean present2 = userRepository.findById(id).isPresent();
        assertTrue(present1);
    }


}
