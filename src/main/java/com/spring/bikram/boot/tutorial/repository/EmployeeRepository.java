package com.spring.bikram.boot.tutorial.repository;

import com.spring.bikram.boot.tutorial.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeName(String employeeName);
}
