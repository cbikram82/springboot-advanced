package com.spring.bikram.boot.tutorial.service;

import com.spring.bikram.boot.tutorial.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee findEmployeeById(Long empId);

    Employee updateEmployee(Long empId, Employee employee);
}
