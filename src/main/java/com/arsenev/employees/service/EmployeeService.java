package com.arsenev.employees.service;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository repository;

    public List<Employee> findAll() {
        log.debug("Enter findAll() method...");
        List<Employee> emps = repository.findAll();
        log.debug("Done findAll() method. Size of Employees list: "+emps.size());
        return emps;
    }
}
