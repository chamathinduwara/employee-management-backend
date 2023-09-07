package com.chamath.Employee.services;

import com.chamath.Employee.entity.EmployeeEnitiy;
import com.chamath.Employee.model.Employee;
import com.chamath.Employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEnitiy employeeEnitiy = new EmployeeEnitiy();
        BeanUtils.copyProperties(employee, employeeEnitiy);
        employeeRepository.save(employeeEnitiy);
        return employee;
    }
}