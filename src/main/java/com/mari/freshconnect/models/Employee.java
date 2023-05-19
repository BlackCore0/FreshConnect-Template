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


}
