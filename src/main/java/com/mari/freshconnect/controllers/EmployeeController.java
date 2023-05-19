package com.mari.freshconnect.controllers;

import com.mari.freshconnect.dto.EmployeeResponse;
import com.mari.freshconnect.exceptions.EmployeeNotFoundException;
import com.mari.freshconnect.models.Employee;
import com.mari.freshconnect.services.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = EmployeeController.employeeControllerPath)
public class EmployeeController {

    static final String employeeControllerPath = "/employees";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping(
            path = "/",
            produces = "application/json"
    )
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        logger.info("Get all employees requested.");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Employees", "ALL");

        return new ResponseEntity<>(
                employeeServices.getAllEmployees(),
                headers,
                HttpStatus.OK
        );
    }
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<EmployeeResponse> getEmployee(
            @PathVariable long id
    ) throws EmployeeNotFoundException {
        logger.info("Get employee ID requested: {}", id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Employee", String.valueOf(id));

        return new ResponseEntity<>(
                employeeServices.getEmployee(id),
                headers,
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/funct/{funct}",
            produces = "application/json")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployeeAboveFunct(
            @PathVariable double funct
    ) {

        logger.info("Get employee above funct requested: {}", funct);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Employees", "ALL");

        return new ResponseEntity<>(
                employeeServices.getEmployeesAboveFunct(funct),
                headers,
                HttpStatus.OK
        );
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<EmployeeResponse> addEmployee(
            @RequestBody Employee employee
    ) {
        EmployeeResponse newEmployee = employeeServices.saveEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Employee", String.valueOf(newEmployee.id()));
        return new ResponseEntity<>(
                newEmployee,
                headers,
                HttpStatus.CREATED
        );
    }

    @PutMapping(
            path = "/{id}",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable long id,
            @RequestBody Employee employee
    ) throws EmployeeNotFoundException {
        logger.info("Update employee ID requested: {}", id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Employee", String.valueOf(id));
        return new ResponseEntity<>(
                employeeServices.updateEmployee(id, employee),
                headers,
                HttpStatus.ACCEPTED
        );
    }

}


