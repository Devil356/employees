package com.arsenev.employees.web.employee;

import com.arsenev.employees.util.WebSocket.Edit;
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
    public Update employeeUpdate(String jsonString) throws JsonProcessingException {
        log.debug("ws json:{}", jsonString);
        ObjectMapper om = new ObjectMapper();
        Map map = om.readValue(jsonString, Map.class);
        Integer draw = (Integer) map.get("draw");
        Integer length = (Integer) map.get("length");
        Integer start = (Integer) map.get("start");
        log.debug("draw:{}, length:{}, start: {}", draw, length, start);
        return new Update(Long.valueOf(draw), Long.valueOf(length), Long.valueOf(start));
    }

    @MessageMapping("/requestForEdit")
    @SendTo("/topic/edit")
    public Edit employeeEdit(Edit edit){
        log.debug("edit:{}",edit.getId());
        return new Edit(edit.getId());
    }
}
