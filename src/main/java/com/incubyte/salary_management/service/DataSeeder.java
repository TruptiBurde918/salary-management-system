package com.incubyte.salary_management.service;

import com.incubyte.salary_management.model.Employee;
import com.incubyte.salary_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            List<Employee> employees = new ArrayList<>();
            for (int i = 1; i <= 10000; i++) {
                Employee emp = new Employee();
                emp.setEmployeeId("EMP" + i);
                emp.setFirstName("First" + i);
                emp.setLastName("Last" + i);
                emp.setEmail("employee" + i + "@acme.com");
                emp.setJobTitle(i % 2 == 0 ? "Developer" : "Manager");
                emp.setSalary(50000.0 + (i * 10));
                emp.setCountry(i % 3 == 0 ? "India" : "USA");
                employees.add(emp);
            }
            repository.saveAll(employees);
            System.out.println("Seeded 10,000 employees into the database.");
        }
    }
}
