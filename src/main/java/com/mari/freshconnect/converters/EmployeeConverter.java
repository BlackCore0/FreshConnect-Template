package com.mari.freshconnect.converters;

import com.mari.freshconnect.dto.EmployeeResponse;
import com.mari.freshconnect.models.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class EmployeeConverter {

    public static EmployeeResponse convert(Employee e){


        return new EmployeeResponse(
                e.getId(),
                e.getFirstName()
        );
    }
    public static List<EmployeeResponse> convert(List<Employee> emps){
        List<EmployeeResponse> empResps = new ArrayList<>();
        emps.forEach(
                e ->empResps.add(convert(e))
        );
        System.out.println("emps = " + empResps.toString());
        return empResps;
    }
}
