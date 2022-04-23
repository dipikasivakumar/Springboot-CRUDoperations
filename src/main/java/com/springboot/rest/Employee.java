package com.springboot.rest;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    private long employeeid;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;

    public Employee(long employeeid, String firstname, String lastname, int age, String designation) {
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.designation = designation;
    }
    public  Employee(){

    }

    @Column(name="age")
    private int age;
    @Column(name="designation")
    private String designation;

    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
