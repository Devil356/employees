package com.arsenev.employees.service;

import com.arsenev.employees.util.exception.NotFoundException;
import com.arsenev.employees.model.Employee;
import com.arsenev.employees.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository repository;

    public Employee get(Long id) {
        log.debug("get()...");
        Employee employee = null;
        employee = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee with id " + id + " not found."));
        log.debug("Done get(). Employee: " + employee);
        return employee;
    }

    public List<Employee> getAll() {
        log.debug("getAll()...");
        List<Employee> employees = repository.findAll();
        log.debug("Done getAll(). Employees list size: " + employees.size());
        return employees;
    }

    public Employee save(Employee employee) {
        log.debug("save()...");
        Employee e = repository.save(employee);
        log.debug("Done save(). Saved employee: " + e);
        return e;
    }

    public void update(Employee employee) {
        log.debug("update()...");
        //TODO: create checkNotFound
        Employee e = repository.save(employee);
        log.debug("Done update(). Updated employee: " + e);
    }

    public void delete(Long id) {
        log.debug("delete()...");
        if (repository.delete(id) == 0) {
            throw new NotFoundException("Employee with id " + id + " not found.");
        }
        log.debug("Done delete(). Id of deleted employee: " + id);
    }

    public List<Employee> getFilter(
            @Nullable String name,
            @Nullable String lastname,
            @Nullable String email,
            @Nullable String phoneNumber
    ) {
        log.debug("getFilter() with parameters: name:{}, lastname:{}," +
                "email:{}, phoneNumber:{}", name, lastname, email, phoneNumber);
        List<Employee> filteredList = repository.getFilter(name, lastname, email, phoneNumber);
        log.debug("Done getFilter(). Size of filtered list: " + filteredList.size());
        return filteredList;
    }
}
