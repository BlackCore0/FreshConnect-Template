package com.mari.freshconnect.services;

import com.mari.freshconnect.converters.EmployeeConverter;
import com.mari.freshconnect.dao.EmployeeDao;
import com.mari.freshconnect.dto.EmployeeResponse;
import com.mari.freshconnect.exceptions.EmployeeNotFoundException;
import com.mari.freshconnect.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    EmployeeDao employeeDao;

    public List<EmployeeResponse> getAllEmployees(){
        return EmployeeConverter.convert(employeeDao.getAllEmployees());
    }

    public EmployeeResponse getEmployee(long id) throws EmployeeNotFoundException{
        return EmployeeConverter.convert(employeeDao.getEmployee(id));
    }

    public EmployeeResponse saveEmployee(Employee emp){
        return EmployeeConverter.convert(employeeDao.addEmployee(emp));
    }

    public EmployeeResponse updateEmployee(long id, Employee newEmp) throws EmployeeNotFoundException {
        return EmployeeConverter.convert(employeeDao.updateEmployee(id, newEmp));
    }

    public List<EmployeeResponse> getEmployeesAboveFunct(double functId){
        return EmployeeConverter.convert(employeeDao.getAboveFunction(functId));
    }
}
