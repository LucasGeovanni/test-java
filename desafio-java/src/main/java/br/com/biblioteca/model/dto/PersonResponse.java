package br.com.biblioteca.model.dto;


import lombok.*;

import java.util.Date;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {

    private Long id;

    private String name;

    private Date birthDate;

    private String document;

    private Boolean employee;

    private Boolean manager;
}
