package com.spring.bikram.boot.tutorial.service;

import com.spring.bikram.boot.tutorial.entity.Employee;
import com.spring.bikram.boot.tutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   @Autowired
   private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long empId) {
        return employeeRepository.findById(empId).get();
    }
}
