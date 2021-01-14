package com.arsenev.employees.web.employee;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.util.Plug;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Контроллер подписчиков и подписок для WebSocket.
 * Имеет единственный метод (пока что), который отправляет всем подписчикам
 * оповещение о том, что необходимо обновить таблицу.
 */
@Controller
public class EmployeeWSController extends AbstractEmployeeController{

    @MessageMapping("/requestForUpdate")
    @SendTo("/topic/updateTable")
    public Plug employeePlug(Employee e){
        return new Plug("Plug");
    }
}
