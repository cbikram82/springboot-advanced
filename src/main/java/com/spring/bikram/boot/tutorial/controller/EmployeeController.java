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
    @DeleteMapping("/employees/{id}")
        public void deleteEmployeeById(@PathVariable("id") Long empID){
         employeeService.deleteEmployeeById(empID);
    }
    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable("id") Long empId){
        return employeeService.findEmployeeById(empId);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long empId,
                                   @RequestBody Employee employee){
        return employeeService.updateEmployee(empId, employee);

    }
}
