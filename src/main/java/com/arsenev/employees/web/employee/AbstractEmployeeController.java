package com.arsenev.employees.web.employee;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.List;

public abstract class AbstractEmployeeController {
    private static final Logger log = LoggerFactory.getLogger(AbstractEmployeeController.class);

    @Autowired
    private EmployeeService service;

    protected List<Employee> getAll() {
        log.debug("getAll()...");
        List<Employee> employees = service.getAll();
        log.debug("Done getAll(). Employees list size: " + employees.size());
        return employees;
    }

    protected List<Employee> getAll(Integer page, Integer size) {
        log.debug("getAll(int, int)...");
        List<Employee> employees = service.getAll(page, size);
        log.debug("Done getAll(int, int). Size of list: " + employees.size());
        return employees;
    }

    protected Employee get(Long id) {
        log.debug("get()...");
        Employee employee = service.get(id);
        log.debug("Done get(). Employee: " + id);
        return employee;
    }


    protected Employee save(Employee employee) {
        log.debug("save()...");
        Employee e = service.save(employee);
        log.debug("Done save(). Saved employee: " + e);
        return e;
    }

    protected void update(Employee employee) {
        log.debug("update()...");
        service.update(employee);
        log.debug("Done update().");
    }

    protected void delete(Long id) {
        log.debug("delete()...");
        service.delete(id);
        log.debug("Done delete(). Id of deleted employee: " + id);
    }

    protected List<Employee> getFilter(
            @Nullable String name,
            @Nullable String lastname,
            @Nullable String email,
            @Nullable String phoneNumber,
            @Nullable Integer page,
            @Nullable Integer size
    ) {
        log.debug("getFilter() with parameters: name:{}, lastname:{}," +
                "email:{}, phoneNumber:{}, page:{}, size:{}", name, lastname, email, phoneNumber, page, size);
        List<Employee> filteredList = service.getFilter(name, lastname, email, phoneNumber, page, size);
        log.debug("Done getFilter(). Size of filtered list: " + filteredList.size());
        return filteredList;
    }
}
