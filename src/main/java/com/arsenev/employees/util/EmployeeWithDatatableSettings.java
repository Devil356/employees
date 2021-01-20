package com.arsenev.employees.util;

import com.arsenev.employees.model.Employee;

import java.util.List;

public class EmployeeWithDatatableSettings {
    private Integer draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<Employee> data;

    public EmployeeWithDatatableSettings(Integer draw, Long recordsTotal, Long recordsFiltered, List<Employee> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
