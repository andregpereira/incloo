package com.andregpereira.challenges.incloo.inclooapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidatura {

    private Long id;
    private String linkedin;
    private String salaryExpectation;
    private String status;
    private byte[] cv;
    private byte[] submittedTechnicalTest;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private Usuario user;
    private Vaga job;

}
