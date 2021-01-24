package com.arsenev.employees.web.history;

import com.arsenev.employees.model.History;
import com.arsenev.employees.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.arsenev.employees.web.history.HistoryRestController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryRestController {
    public static final String REST_URL = "/rest/history";

    private static final Logger log = LoggerFactory.getLogger(HistoryRestController.class);

    @Autowired
    private HistoryService service;

    @GetMapping("/{id}")
    public List<History> getHistory(@PathVariable Long id) {
        log.debug("getHistory() with id: {}...", id);
        List<History> history = service.getAllById(id);
        log.debug("Done getHistory(). List size: {}", history.size());
        return history;
    }
}
