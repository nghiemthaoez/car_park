package com.example.carpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(length = 50)
    private String employeeFullname;
    @Column()
    private LocalDate employeeBirthday;
    @Column()
    private String sex;
    @Column(length = 50)
    private String employeeAddress;
    @Column(length = 50)
    private String employeePhonenumber;
    @Column(length = 50)
    private String employeeEmail;
    @Column(unique = true)
    private String account;
    @Column()
    private String password;
    @Column()
    private String department;

}
