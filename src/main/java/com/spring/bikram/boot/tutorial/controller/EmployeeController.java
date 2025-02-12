package com.spring.bikram.boot.tutorial.controller;

import com.spring.bikram.boot.tutorial.entity.Employee;
import com.spring.bikram.boot.tutorial.service.EmployeeService;
import com.spring.bikram.boot.tutorial.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Employee Management", description = "APIs for managing employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RecommendationService recommendationService;

    @Operation(summary = "Create a new employee")
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @Operation(summary = "Get all employees")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long empID) {
        employeeService.deleteEmployeeById(empID);
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable("id") Long empId) {
        return employeeService.findEmployeeById(empId);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long empId,
                                   @RequestBody Employee employee) {
        return employeeService.updateEmployee(empId, employee);
    }

    @Operation(summary = "Get similar employees based on location")
    @GetMapping("/employees/{id}/similar")
    public List<Employee> getSimilarEmployees(
            @Parameter(description = "Employee ID") @PathVariable("id") Long empId,
            @Parameter(description = "Maximum number of recommendations") 
            @RequestParam(defaultValue = "5") int limit) {
        return recommendationService.getSimilarEmployees(empId, limit);
    }
}
