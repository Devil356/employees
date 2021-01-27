package com.arsenev.employees.util;

import com.arsenev.employees.model.Employee;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeWithDatatableSettings that = (EmployeeWithDatatableSettings) o;
        return Objects.equals(draw, that.draw) && Objects.equals(recordsTotal, that.recordsTotal) && Objects.equals(recordsFiltered, that.recordsFiltered) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(draw, recordsTotal, recordsFiltered, data);
    }
}
