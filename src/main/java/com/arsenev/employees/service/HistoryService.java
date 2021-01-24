package com.arsenev.employees.service;

import com.arsenev.employees.model.History;
import com.arsenev.employees.repository.HistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private static final Logger log = LoggerFactory.getLogger(HistoryService.class);

    @Autowired
    private HistoryRepository repository;

    public List<History> getAllById(Long id) {
        log.debug("getAllById() with id: {}...", id);
        List<History> history = repository.findAllByEmployeeId(id);
        log.debug("Done getAllById(). List size: {}", history.size());
        return history;
    }
}
