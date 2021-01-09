package com.arsenev.employees.web.employee;


import com.arsenev.employees.model.Employee;
import com.arsenev.employees.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> findAll() {
        log.debug("Enter findAll() method...");
        List<Employee> employees = service.findAll();
        log.debug("Done findAll() method. Size of Employees list: " + employees.size());
        return employees;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        //TODO: logging
        Employee e = service.create(employee);
        return e;
    }
}
