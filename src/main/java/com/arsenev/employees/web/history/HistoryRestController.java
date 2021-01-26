package com.arsenev.employees.web.history;

import com.arsenev.employees.model.History;
import com.arsenev.employees.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.arsenev.employees.web.history.HistoryRestController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryRestController {
    public static final String REST_URL = "/rest/history";

    private static final Logger log = LoggerFactory.getLogger(HistoryRestController.class);

    private final HistoryService service;

    @Autowired
    public HistoryRestController(HistoryService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public List<History> get(
            @PathVariable Long id
    ) {
        log.debug("get() with id: {}...", id);
        List<History> history = service.getAllById(id);
        log.debug("Done get(). List size: {}", history.size());
        return history;
    }

    @GetMapping
    public List<History> get() {
        log.debug("get()...");
        List<History> history = new ArrayList<>();
        log.debug("Done get()");
        return history;
    }
}
