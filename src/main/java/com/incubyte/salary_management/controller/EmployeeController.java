package com.incubyte.salary_management.controller;

import com.incubyte.salary_management.model.Employee;
import com.incubyte.salary_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:4200") // This allows Angular to talk to Java
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public Page<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
}
