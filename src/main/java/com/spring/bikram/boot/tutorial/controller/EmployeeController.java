package com.spring.bikram.boot.tutorial.controller;


import com.spring.bikram.boot.tutorial.entity.Employee;
import com.spring.bikram.boot.tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable("id") Long empId){
        return employeeService.findEmployeeById(empId);
    }
}
