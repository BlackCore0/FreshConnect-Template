package com.mari.freshconnect.dto;

import java.time.LocalDate;

public record EmployeeResponse(long id,
                               String firstName,
                               String lastName,
                               String email,
                               double funcGroup,
                               LocalDate dateOfBirth,
                               int age) {

}
