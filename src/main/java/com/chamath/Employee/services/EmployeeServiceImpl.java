package com.chamath.Employee.services;

import com.chamath.Employee.entity.EmployeeEnitiy;
import com.chamath.Employee.model.Employee;
import com.chamath.Employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEnitiy> employeeEnitiys = employeeRepository.findAll();
        List<Employee> employees =  employeeEnitiys
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public boolean deteteEmployee(long id) {
        EmployeeEnitiy employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        EmployeeEnitiy employeeEnitiy = employeeRepository.findById(employee.getId()).get();
        employeeEnitiy.setEmailId(employee.getEmailId());
        employeeEnitiy.setFirstName(employee.getFirstName());
        employeeEnitiy.setLastName(employee.getLastName());
        employeeRepository.save(employeeEnitiy);
        return (employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        EmployeeEnitiy employeeEnitiy = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEnitiy, employee);
        return employee;
    }
}
