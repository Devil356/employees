package com.arsenev.employees.service;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.EmployeeTestData;
import com.arsenev.employees.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import javax.transaction.Transactional;

import static com.arsenev.employees.EmployeeTestData.getNew;
import static com.arsenev.employees.EmployeeTestData.getUpdated;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Sql(scripts = {"classpath:data.sql"}, config = @SqlConfig(encoding = "UTF-8"))
@Transactional
public class EmployeeServiceTest {
    @Autowired
    protected EmployeeService service;

    @Test
    void delete() {
        service.delete(EmployeeTestData.EMPLOYEE5.getId());
        assertThrows(NotFoundException.class, () -> service.get(EmployeeTestData.EMPLOYEE5.getId()));
    }

    @Test
    void create() {
        Employee created = service.save(getNew());
        Long newId = created.getId();
        Employee newEmployee = getNew();
        newEmployee.setId(newId);
        assertEquals(created, newEmployee);
        assertEquals(service.get(newId), newEmployee);
    }

    @Test
    void get() {
        Employee actual = service.get(EmployeeTestData.EMPLOYEE5.getId());
        Employee createdEmployee = EmployeeTestData.EMPLOYEE5;
        createdEmployee.setId(actual.getId());
        assertEquals(actual, createdEmployee);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(EmployeeTestData.NOT_FOUND));
    }

    @Test
    void update() {
        Employee updated = getUpdated();
        service.save(updated);
        assertEquals(service.get(updated.getId()), getUpdated());
    }
}
