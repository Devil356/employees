package com.arsenev.employees.repository;

import com.arsenev.employees.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(
            "SELECT e " +
                    "FROM Employee e " +
                    "WHERE e.name LIKE CONCAT('%',:name,'%') " +
                    "AND e.lastname LIKE CONCAT('%',:lastname,'%') " +
                    "AND e.email LIKE CONCAT('%',:email,'%') " +
                    "AND e.phoneNumber LIKE CONCAT('%',:phoneNumber,'%') "
    )
    Page<Employee> findAll(
            @Param("name") String name,
            @Param("lastname") String lastname,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber,
            Pageable pageable
    );

//    https://stackoverflow.com/questions/44022076/jparepository-not-supported-for-dml-operations-delete-query/47066201
    @Transactional
    @Modifying
    @Query(
            "DELETE " +
                    "FROM Employee e " +
                    "WHERE e.id=:id"
    )
    int delete(@Param("id") Long id);
}
