package com.arsenev.employees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_generator"
    )
    @SequenceGenerator(
            name = "employee_generator",
            sequenceName = "employee_seq",
            allocationSize = 1
    )
    private Long id;

    @NotBlank
    @Column(name = "name")
    @Size(min = 2, max = 100, message = "Name must be between 2 to 100 symbols")
    private String name;

    @NotBlank
    @Column(name = "lastname")
    @Size(min = 2, max = 100, message = "Lastname must be between 2 to 100 symbols")
    private String lastname;

    @Email
    @NotBlank
    @Column(name = "email")
    @Size(max = 100, message = "Length must be to 100 symbols")
    private String email;

    @NotBlank
    @Column(name = "phone_number")
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    private String phoneNumber;

}
