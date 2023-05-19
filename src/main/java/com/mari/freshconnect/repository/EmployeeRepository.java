package com.mari.freshconnect.repository;

import com.mari.freshconnect.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findAllByFuncGroupGreaterThanEqual(Double funcGroup);

    public List<Employee> findByFuncGroupGreaterThan(Double funcgroup);

    public Optional<Employee> findByEmail(String email);

}
