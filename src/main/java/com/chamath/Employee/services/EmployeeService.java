package com.chamath.Employee.services;

import com.chamath.Employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    boolean deteteEmployee(long id);

    boolean updateEmployee(Employee employee);
}
