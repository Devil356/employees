package com.arsenev.employees.testData;

import com.arsenev.employees.model.Employee;

import java.util.List;

public class EmployeeTestData {
    public static Employee EMPLOYEE1 = new Employee(100000L, "Работник1", "Работников1", "rabotnik1@gmail.com", "89995848391");
    public static Employee EMPLOYEE2 = new Employee(100001L, "Работник2", "Работников2", "rabotnik2@gmail.com", "89995848392");
    public static Employee EMPLOYEE3 = new Employee(100002L, "Работник3", "Работников3", "rabotnik3@gmail.com", "89995848393");
    public static Employee EMPLOYEE4 = new Employee(100003L, "Работник4", "Работников4", "rabotnik4@gmail.com", "89995848394");
    public static Employee EMPLOYEE5 = new Employee(100004L, "Работник5", "Работников5", "rabotnik5@gmail.com", "89995848395");
    public static Employee EMPLOYEE6 = new Employee(100005L, "Работник6", "Работников6", "rabotnik6@gmail.com", "89995848396");
    public static Employee EMPLOYEE7 = new Employee(100006L, "Работник7", "Работников7", "rabotnik7@gmail.com", "89995848397");
    public static Employee EMPLOYEE8 = new Employee(100007L, "Работник8", "Работников8", "rabotnik8@gmail.com", "89995848398");
    public static Employee EMPLOYEE9 = new Employee(100008L, "Работник9", "Работников9", "rabotnik9@gmail.com", "89995848399");

    public static List<Employee> getAll() {
        return List.of(
                EMPLOYEE1,
                EMPLOYEE2,
                EMPLOYEE3,
                EMPLOYEE4,
                EMPLOYEE5,
                EMPLOYEE6,
                EMPLOYEE7,
                EMPLOYEE8,
                EMPLOYEE9
        );
    }
}
