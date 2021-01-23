package com.arsenev.employees;

import com.arsenev.employees.model.Employee;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class EmployeeTestData {
    public static Employee EMPLOYEE1 = new Employee(100000L, "Abigail", "Wall", "libero.nec@arcuacorci.ca", "35487021465", LocalDateTime.of(2021, Month.JUNE, 18, 18, 50, 34));
    public static Employee EMPLOYEE2 = new Employee(100001L, "Griffin", "Hays", "et@Donecconsectetuermauris.edu", "21876305386", LocalDateTime.of(2021, Month.DECEMBER, 21, 16, 24, 30));
    public static Employee EMPLOYEE3 = new Employee(100002L, "Blythe", "Watts", "nonummy.ultricies@Uttincidunt.edu", "87581396664", LocalDateTime.of(2020, Month.DECEMBER, 1, 0, 10, 33));
    public static Employee EMPLOYEE4 = new Employee(100003L, "Candice", "Garner", "interdum.enim.non@feugiatplaceratvelit.com", "53048958508", LocalDateTime.of(2020, Month.APRIL, 8, 1, 0, 32));
    public static Employee EMPLOYEE5 = new Employee(100004L, "Merritt", "Kidd", "amet@quisaccumsanconvallis.ca", "91888319040", LocalDateTime.of(2021, Month.JUNE, 3, 6, 55, 14));
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
        return new Employee(null, "Новый", "Новов", "new@gmail.com", "89998989988", LocalDateTime.of(2000, Month.APRIL, 10, 2, 30));
    }

    public static Employee getUpdated() {
        return new Employee(100004L, "Обновленный", "Обновленов", "updated@gmail.com", "89998989988", LocalDateTime.of(2020, Month.AUGUST, 10, 2, 30));
    }
}
