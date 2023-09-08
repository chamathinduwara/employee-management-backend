package com.chamath.Employee.contorller;

import com.chamath.Employee.model.Employee;
import com.chamath.Employee.services.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeServiceImpl employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(
            @RequestBody Employee employee
    ){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
}
