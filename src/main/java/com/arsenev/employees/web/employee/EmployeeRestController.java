package com.arsenev.employees.web.employee;


import com.arsenev.employees.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController extends AbstractEmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping
    public List<Employee> findAll(
//            Integer displayStart,
//            @RequestParam(defaultValue = "10") Integer length
    ) {
//        Pageable pageable = PageRequest.of(displayStart, length);
        return super.getAll(/*pageable*/);
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return super.get(id);
    }

    @PostMapping
    public Employee create(@Valid Employee employee) {
        return super.save(employee);
    }

    @DeleteMapping("/{id}")
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
