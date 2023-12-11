package br.com.biblioteca.model.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
public class PersonRequest {

    @NonNull
    private String name;

    private LocalDate birthDate;

    private String document;

    private Boolean employee;

    private Boolean manager;
}
