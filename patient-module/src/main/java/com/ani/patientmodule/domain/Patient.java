package com.ani.patientmodule.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;
@Data
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @NotNull
    @Column(unique = false, nullable = false)
    private String name;


    @Column(unique = false, nullable = true)
    private long mobile;


    @NotNull
    @Column(unique = false, nullable = false)
    private int age;


    @NotNull
    @Column(unique = false, nullable = false)
    private boolean status;

    @Column(unique = false, nullable = true)
    private LocalDate lastVisited;
}
