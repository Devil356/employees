package com.arsenev.employees.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//TODO: create description

@Controller
public class RootController {
    private static final Logger LOG = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public String getAll(){
        LOG.debug("ENTER GETALL");
        return "employees";
    }
}
