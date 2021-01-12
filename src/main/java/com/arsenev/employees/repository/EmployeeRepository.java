package com.arsenev.employees.repository;

import com.arsenev.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//TODO: create description
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(
            "SELECT e " +
                    "FROM Employee e " +
                    "WHERE e.name LIKE CONCAT('%',:name,'%') " +
                    "AND e.lastname LIKE CONCAT('%',:lastname,'%') " +
                    "AND e.email LIKE CONCAT('%',:email,'%') " +
                    "AND e.phoneNumber LIKE CONCAT('%',:phoneNumber,'%') "
    )
    List<Employee> getFilter(
            @Param("name") String name,
            @Param("lastname") String lastname,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber
    );

}
