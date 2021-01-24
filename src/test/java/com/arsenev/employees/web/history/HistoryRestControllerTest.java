package com.arsenev.employees.web.history;

import com.arsenev.employees.service.HistoryService;
import com.arsenev.employees.web.AbstractRestControllerTest;
import com.arsenev.employees.web.employee.EmployeeRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class HistoryRestControllerTest extends AbstractRestControllerTest {
    protected static final String REST_URL = EmployeeRestController.REST_URL;

    @Autowired
    protected HistoryService service;

    @Test
    void getHistory() {
    }
}