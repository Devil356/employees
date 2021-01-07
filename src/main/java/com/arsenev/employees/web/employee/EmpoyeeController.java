package com.arsenev.employees.web.employee;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmpoyeeController {
    private static final Logger log = LoggerFactory.getLogger(EmpoyeeController.class);
    @Autowired
    private EmployeeService service;

    @GetMapping
    public String findAll(Model model) {
        log.debug("Enter findAll() method...");
        List<Employee> employees = service.findAll();
        log.debug("Done findAll() method. Size of Employees list: "+employees.size());
        model.addAttribute("employees", employees);
        log.debug("Successful set attribute to model");
        return "employees";
    }
}
