package com.arsenev.employees.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "history")
@Data
public class History {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "history_generator"
    )
    @SequenceGenerator(
            name = "history_generator",
            sequenceName = "history_seq",
            allocationSize = 1
    )
    private Long id;

    @NotNull
    @Column(name = "employee_id")
    private Long employeeId;

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

    @NotNull
    @Column(name = "edit_time", nullable = false)
    private Date editTime = new Date();

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_id", nullable = false)
//    @JsonBackReference
//    private Employee employee;

    public History() {
    }

    public History(Long id, @NotBlank @Size(min = 2, max = 100, message = "Name must be between 2 to 100 symbols") String name, @NotBlank @Size(min = 2, max = 100, message = "Lastname must be between 2 to 100 symbols") String lastname, @Email @NotBlank @Size(max = 100, message = "Length must be to 100 symbols") String email, @NotBlank @Size(min = 11, max = 11, message = "Phone number must be 11 characters") String phoneNumber, @NotNull Date editTime) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.editTime = editTime;
    }
}
