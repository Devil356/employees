package com.arsenev.employees.repository;

import com.arsenev.employees.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllByEmployeeId(Long id);
}
