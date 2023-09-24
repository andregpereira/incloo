package com.andregpereira.challenges.incloo.inclooapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String mobileNumber;
    private LocalDate birthDate;
    private Integer age;
    private String ethnicity;
    private Boolean lgbtqia;
    private String disability;
    private String familyIncome;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private boolean active;
    private List<Candidatura> jobApplications = new ArrayList<>();

}
