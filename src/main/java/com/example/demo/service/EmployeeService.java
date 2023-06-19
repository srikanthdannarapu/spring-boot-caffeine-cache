package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @PostConstruct
    public void init() {
        getEmployees();
        getEmployees();
    }

    @Cacheable("employeesCache") // Specify the cache name
    public List<Employee> getEmployees() {
        // Simulated expensive API call or database query
        // Fetch employees from the source
        List<Employee> employees = fetchEmployeesFromSource();
        return employees;
    }

    private List<Employee> fetchEmployeesFromSource() {
        // Simulated implementation for fetching employees from source
        // This method will be invoked only if the cache is empty or invalidated
        // Replace it with your actual implementation
        // ...
        System.out.println("employees are fetched from resource");
        List<Employee> employees = Arrays.asList(new Employee(1, "sri"),
                new Employee(2, "ram"),
                new Employee(3, "raj"));
        return employees;
    }
}
