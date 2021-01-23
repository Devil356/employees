package com.arsenev.employees.web.employee;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.util.JsonUtil;
import com.arsenev.employees.util.WebSocket.Delete;
import com.arsenev.employees.util.WebSocket.Update;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Контроллер подписчиков и подписок для WebSocket.
 * Имеет единственный метод (пока что), который отправляет всем подписчикам
 * оповещение о том, что необходимо обновить таблицу.
 */
@Controller
public class EmployeeWSController extends AbstractEmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeWSController.class);

    @MessageMapping("/requestForUpdate")
    @SendTo("/topic/updateTable")
    public Employee employeeUpdate(String jsonString) {
        log.debug("jsonString: {}", jsonString);
        Employee editedEmployee = JsonUtil.readValue(jsonString, Employee.class);
        log.debug("Edited employee: {}", editedEmployee);
        return editedEmployee;
    }

    @MessageMapping("/requestForDelete")
    @SendTo("/topic/delete")
    public Delete employeeDelete(Delete delete){
        log.debug("delete:{}",delete.getId());
        return new Delete(delete.getId());
    }
}
