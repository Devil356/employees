package com.arsenev.employees.service;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.testData.EmployeeTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;


@SpringJUnitWebConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@ExtendWith(SpringExtension.class)
@Sql(scripts = {
        "classpath:db/populateDb.sql"
}, config = @SqlConfig(encoding = "UTF-8"))
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Test
    void findAll() {
        List<Employee> fromDb = service.findAll();
        List<Employee> testData = EmployeeTestData.getAll();
        Assertions.assertEquals(fromDb, testData);
    }
}