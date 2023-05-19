package com.mari.freshconnect.models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;
    @Column(name = "FIRST_NAME",
            length = 512,
            nullable = false)
    private String firstName;
    @Column(name = "MIDDLE_NAME",
            length = 512,
            nullable = false)
    private String middleName;
    @Column(name = "LAST_NAME",
            length = 512,
            nullable = false)
    private String lastName;
    @Column(name = "EMAIL",
            length = 512,
            nullable = false,
            unique = true)
    private String email;
    @Column(name = "FUNCGROUP",
    nullable = false)
    private double funcGroup;
    @Column(name = "SALARY",
    nullable = false,
    precision = 6)
    private double salary;
    @Column(name = "DOB",
    nullable = false)
    private LocalDate dateOfBirth;

    public Employee() {
    }

    public Employee(
                    String firstName, String middleName, String lastName, String email,
                    double funcGroup, double salary,
                    LocalDate dateOfBirth) {
//        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.funcGroup = funcGroup;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }
    public Employee(long id,
                    String firstName, String middleName, String lastName, String email,
                    double funcGroup, double salary,
                    LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.funcGroup = funcGroup;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getFuncGroup() {
        return funcGroup;
    }

    public void setFuncGroup(double funcGroup) {
        this.funcGroup = funcGroup;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
