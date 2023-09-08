package com.chamath.Employee.contorller;

import com.chamath.Employee.model.Employee;
import com.chamath.Employee.services.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable("id") long id) {
        boolean deleted = false;
        deleted = employeeService.deteteEmployee(id);
        Map<String ,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/employee")
    public ResponseEntity<Map<String,Boolean>> updateEmployee(
            @RequestBody Employee employee
    ){
        boolean update = false;
        update = employeeService.updateEmployee(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", update);
        return ResponseEntity.ok(response);
    }
}
