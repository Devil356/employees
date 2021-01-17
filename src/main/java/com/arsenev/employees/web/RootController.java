package com.arsenev.employees.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Перенаправляет из корня рута (localhost:8080) в view с главной страницей.
 * Аннотация ApiIgnore для того, чтобы Swagger не заносил в документацию данный контроллер.
 */
@ApiIgnore
@Controller
public class RootController {
    private static final Logger LOG = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public String getAll(){
        LOG.debug("getAll()...");
        return "employees";
    }
}
