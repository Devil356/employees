package com.arsenev.employees;

import com.arsenev.employees.model.Employee;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class EmployeeTestData {
    public static final TestMatcher<Employee> EMPLOYEE_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Employee.class, "editTime");

    public static Employee EMPLOYEE1 = new Employee(100000L, "Elton", "Schroeder", "Mauris.quis.turpis@tortorIntegeraliquam.net", "14483337825");
    public static Employee EMPLOYEE2 = new Employee(100001L, "Gareth", "Spears", "neque.pellentesque@congueIn.org", "11406667426");
    public static Employee EMPLOYEE3 = new Employee(100002L, "Isadora", "Combs", "urna@laciniaat.co.uk", "14521324318");
    public static Employee EMPLOYEE4 = new Employee(100003L, "Leah", "Marshall", "Suspendisse.eleifend@urna.net", "13297659794");
    public static Employee EMPLOYEE5 = new Employee(100005L, "Silas", "Waller", "ut@nec.co.uk", "19671177428");
    public static Long NOT_FOUND = 1000000L;

    public static List<Employee> getAll() {
        return List.of(
                EMPLOYEE1,
                EMPLOYEE2,
                EMPLOYEE3,
                EMPLOYEE4,
                EMPLOYEE5
        );
    }

    public static Employee getNew() {
        return new Employee(null, "Новый", "Новов", "new@gmail.com", "89998989988", new Date());
    }

    public static Employee getUpdated() {
        return new Employee(100005L, "Обновленный", "Обновленов", "updated@gmail.com", "89998989988", new Date());
    }
}
