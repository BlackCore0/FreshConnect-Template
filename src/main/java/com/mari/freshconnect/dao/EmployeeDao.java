package com.mari.freshconnect.dao;

import com.mari.freshconnect.exceptions.EmployeeNotFoundException;
import com.mari.freshconnect.models.Employee;
import com.mari.freshconnect.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDao {
//    private static final List<Employee> employees = new ArrayList<>();

//    public EmployeeDao() {
//
//        employees.add(new Employee(1L, "Elton", null, "John", "elton@gmail.com", 8.0, 3000.00, LocalDate.of(1988, 12, 13)));
//        employees.add(new Employee(2L, "Michael", null, "Jakson", "michael@gmail.com", 7.0, 3500.00, LocalDate.of(1988, 12, 13)));
//        employees.add(new Employee(3L, "Ed", null, "Sheeran", "ed@gmail.com", 6.0, 2500.00, LocalDate.of(1988, 12, 13)));
//        employees.add(new Employee(4L, "Elvis", null, "Presley", "elvis@gmail.com", 5.0, 2000.00, LocalDate.of(1988, 12, 13)));
//        employees.add(new Employee(5L, "John", null, "Lenon", "john@gmail.com", 4.0, 1500.00, LocalDate.of(1988, 12, 13)));
//        employees.add(new Employee(6L, "George", null, "Harrison", "george@gmail.com", 3.0, 5000.00, LocalDate.of(1988, 12, 13)));
//        employees.add(new Employee(7L, "Tahsan", "A", "Khan", "tahsan@gmail.com", 2.0, 55000.00, LocalDate.of(1988, 12, 13)));
//
//
//        Employee e8 = new Employee(8L, "James", "C", "Guru", "james@gmail.com",
//                1.0, 6000.00, LocalDate.of(1988, 12, 13));
//
//        Employee e9 = new Employee(9L, "Shafaat", "Sheik", "Giasuddin", "rshafaat@gmail.com",
//                1.0, 6000.00, LocalDate.of(1999, 12, 13));
//
//        Employee e10 = new Employee(10L, "Mark", "", "Bokhorst", "m.bokhorst@gmail.com",
//                5.0, 5000.00, LocalDate.of(1999, 12, 13));
//
//
//        employees.add(e8);
//        employees.add(e9);
//        employees.add(e10);
//
//    }

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id) throws EmployeeNotFoundException {
        Optional<Employee> emp = employeeRepository.findById(id);
        if(!emp.isPresent()){
            throw new EmployeeNotFoundException("Employee not found: "+ id);
        }
        return emp.get();
    }

    public List<Employee> getAboveFunction(double functId) {
        return employeeRepository.findByFuncGroupGreaterThan(functId);
    }

    public Employee addEmployee(Employee emp){

        return employeeRepository.save(emp);
    }

    public Employee updateEmployee(long id, Employee newEmployee) throws EmployeeNotFoundException {

        newEmployee.setId(id);
        return employeeRepository.save(newEmployee);
    }

}
