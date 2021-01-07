package com.arsenev.employees.web.employee;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmpoyeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public String getAll(Model model) {
        List<Employee> emps = service.findAll();
        model.addAttribute("employees", emps);
        return "employees";
    }
}
