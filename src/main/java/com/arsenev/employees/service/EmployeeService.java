package com.arsenev.employees.service;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.repository.EmployeeRepository;
import com.arsenev.employees.util.EmployeeWithDatatableSettings;
import com.arsenev.employees.util.JsonUtil;
import com.arsenev.employees.util.cache.CacheHelper;
import com.arsenev.employees.util.cache.CacheHelper.DatatableRequest;
import com.arsenev.employees.util.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository repository;

    private final Map<String, List<Map<DatatableRequest, Page<Employee>>>> cacheForGetAll = new HashMap<>();

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee get(Long id) {
        log.debug("get()...");
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee with id " + id + " not found."));
        log.debug("Done get(). Employee: " + employee);
        return employee;
    }

    public EmployeeWithDatatableSettings getAll(
            Integer draw,
            Integer start,
            Integer length,
            String searchJson,
            String UUID
    ) {
        log.debug("getAll() with parameters: start:{}, length:{}, searchJson:{}, UUID:{}",
                start, length, searchJson, UUID);
        if (searchJson == null) {
            EmployeeWithDatatableSettings ewds = checkAndReturnCachedIfExists(draw, start, length, UUID);
            log.debug("Done getAll() on page:{}. RecordsTotal:{}, recordsFiltered:{}", start / length, ewds.getRecordsTotal(), ewds.getRecordsFiltered());
            return ewds;
        }
        Map<String, String> search = JsonUtil.readValue(searchJson, Map.class);
        Page<Employee> employees = repository.findAll(
                search.get("name"),
                search.get("lastname"),
                search.get("email"),
                search.get("phoneNumber"),
                PageRequest.of(start / length, length, Sort.by(Sort.Direction.ASC, "id"))
        );
        log.debug("Done getAll() on page:{}. Employees list size:{}", start / length, employees.getContent().size());
        return new EmployeeWithDatatableSettings(draw, repository.count(), employees.getTotalElements(), employees.getContent());
    }

    private EmployeeWithDatatableSettings checkAndReturnCachedIfExists(
            Integer draw,
            Integer start,
            Integer length,
            String UUID
    ) {
        Page<Employee> employeePage = null;
        if (cacheForGetAll.containsKey(UUID)) {
            DatatableRequest dtreq = CacheHelper.getDatatableRequest(start, length);
            Map<DatatableRequest, Page<Employee>> employeesMap = cacheForGetAll.get(UUID);
            for (DatatableRequest datatableRequest : employeesMap.keySet()) {
                if (datatableRequest.equals(dtreq)) {
                    employeePage = employeesMap.get(datatableRequest);
                }
            }
        }
        if (employeePage == null) {
            employeePage = putInCache(draw, start, length, UUID);

        }
        return new EmployeeWithDatatableSettings(draw, repository.count(), employeePage.getTotalElements(), employeePage.getContent());
    }

    private Page<Employee> putInCache(Integer draw, Integer start, Integer length, String UUID) {
        Page<Employee> employeePage = repository.findAll(
                PageRequest.of(start / length, length, Sort.by(Sort.Direction.ASC, "id"))
        );
        if (cacheForGetAll.containsKey(UUID)) {
            cacheForGetAll.get(UUID).put(CacheHelper.getDatatableRequest(start, length), employeePage);
        }
        //для установки нужного параметра draw в кэше
        validCache(draw, UUID);

        return employeePage;
    }

    private void validCache(Integer draw, String UUID) {
        for (Map.Entry<String, Map<DatatableRequest, Page<Employee>>> stringMapEntry : cacheForGetAll.entrySet()) {
            if (stringMapEntry.getKey().equals(UUID)) {
                stringMapEntry.getValue().
            }
        }
    }

    public Employee save(Employee employee) {
        log.debug("save()...");
        Employee e = repository.save(employee);
        log.debug("Done save(). Saved employee: " + e);
        return e;
    }

    public void update(Employee employee) {
        log.debug("update()...");
        //TODO: create checkNotFound
        Employee e = repository.save(employee);
        log.debug("Done update(). Updated employee: " + e);
    }

    public void delete(Long id) {
        log.debug("delete()...");
        if (repository.delete(id) == 0) {
            throw new NotFoundException("Employee with id " + id + " not found.");
        }
        log.debug("Done delete(). Id of deleted employee: " + id);
    }

    public Long count() {
        log.debug("count()...");
        Long count = repository.count();
        log.debug("Done count()... Value is: " + count);
        return count;
    }
}
