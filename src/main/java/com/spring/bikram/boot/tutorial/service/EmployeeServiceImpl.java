package com.spring.bikram.boot.tutorial.service;

import com.spring.bikram.boot.tutorial.entity.Employee;
import com.spring.bikram.boot.tutorial.exception.ResourceNotFoundException;
import com.spring.bikram.boot.tutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
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
        return employeeRepository.findById(empId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + empId));
    }

    @Override
    public Employee updateEmployee(Long empId, Employee employee) {
        Employee empDB = findEmployeeById(empId);
        
        if(StringUtils.isNotBlank(employee.getEmployeeName())) {
            empDB.setEmployeeName(employee.getEmployeeName());
        }
        if(StringUtils.isNotBlank(employee.getEmployeeLocation())) {
            empDB.setEmployeeLocation(employee.getEmployeeLocation());
        }

        return employeeRepository.save(empDB);
    }


    @Override
    public void deleteEmployeeById(Long empID) {
        employeeRepository.deleteById(empID);
    }
}
