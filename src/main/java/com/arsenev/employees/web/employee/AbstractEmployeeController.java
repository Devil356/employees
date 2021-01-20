package com.arsenev.employees.web.employee;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.service.EmployeeService;
import com.arsenev.employees.util.EmployeeWithDatatableSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.List;

public abstract class AbstractEmployeeController {
    private static final Logger log = LoggerFactory.getLogger(AbstractEmployeeController.class);

    @Autowired
    private EmployeeService service;

    protected EmployeeWithDatatableSettings getAll(
            Integer draw,
            Integer start,
            Integer length,
            String searchJson
    ) {
        log.debug("getAll()...");
        EmployeeWithDatatableSettings e = service.getAll(draw, start, length, searchJson);
        log.debug("Done getAll(). Employees list size: " + e.getData().size());
        return e;
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

    protected Long count() {
        log.debug("count()...");
        Long count = service.count();
        log.debug("Done count().");
        return count;
    }
}
