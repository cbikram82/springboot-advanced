package com.spring.bikram.boot.tutorial.service;

import com.spring.bikram.boot.tutorial.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AILocationSimilarityService aiLocationSimilarityService;

    public List<Employee> getSimilarEmployees(Long employeeId, int limit) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        String location = employee.getEmployeeLocation();
        
        return employeeService.getAllEmployees().stream()
            .filter(emp -> !emp.getEmployeeID().equals(employeeId))
            .filter(emp -> emp.getEmployeeLocation() != null)
            .filter(emp -> {
                try {
                    double similarity = aiLocationSimilarityService.calculateSimilarity(
                        location, emp.getEmployeeLocation());
                    return similarity > 0.7; // Threshold for semantic similarity
                } catch (Exception e) {
                    return false;
                }
            })
            .sorted((emp1, emp2) -> {
                try {
                    double similarity1 = aiLocationSimilarityService.calculateSimilarity(
                        location, emp1.getEmployeeLocation());
                    double similarity2 = aiLocationSimilarityService.calculateSimilarity(
                        location, emp2.getEmployeeLocation());
                    return Double.compare(similarity2, similarity1);
                } catch (Exception e) {
                    return 0;
                }
            })
            .limit(limit)
            .collect(Collectors.toList());
    }
} 