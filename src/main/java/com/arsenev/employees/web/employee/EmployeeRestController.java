package com.arsenev.employees.web.employee;


import com.arsenev.employees.model.Employee;
import com.arsenev.employees.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> findAll() {
        log.debug("Enter findAll() method...");
        List<Employee> employees = repository.findAll();
        log.debug("Done findAll() method. Employees list: " + employees);
        return employees;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        log.debug("Enter create() method...");
        Employee e = repository.save(employee);
        log.debug("Done create() method. Created employee: " + employee);
        return e;
    }
}
