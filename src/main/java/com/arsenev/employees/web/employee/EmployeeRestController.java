package com.arsenev.employees.web.employee;


import com.arsenev.employees.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * RestController для передачи данных для отрисовки в Datatables.
 * Методы класса отдают объекты в JSON формате. Аннотирован @RestController,
 * т.к. имеет у своего родителя аннотацию @ResponseBody, которая нужна для
 * передачи тела из методов в требуемом формате, который обозначен в
 * параметре @produces аннотации @RequestMapping.
 * <p>
 * Записи в лог осуществляет родитель.
 */
@RestController
@RequestMapping(value = EmployeeRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController extends AbstractEmployeeController {
    public static final String REST_URL = "/rest";

    private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping
    public List<Employee> findAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return super.get(id);
    }

    /**
     * Аннотация @Valid - для проверки валидности данных.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        Employee created = super.save(employee);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Employee employee) {
        super.update(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }

    @GetMapping("/filter")
    public List<Employee> getFilter(
            @RequestParam(name = "fname") @Nullable String name,
            @RequestParam(name = "flastname") @Nullable String lastname,
            @RequestParam(name = "femail") @Nullable String email,
            @RequestParam(name = "fphoneNumber") @Nullable String phoneNumber
    ) {
        return super.getFilter(name, lastname, email, phoneNumber);
    }
}
