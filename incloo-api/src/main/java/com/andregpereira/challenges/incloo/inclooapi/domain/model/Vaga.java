package com.andregpereira.challenges.incloo.inclooapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaga {

    private Long id;
    private String title;
    private String description;
    private Set<String> minorityGroups = new LinkedHashSet<>();
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private boolean active;
    private List<Candidatura> jobApplications = new ArrayList<>();

}
