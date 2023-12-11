package br.com.biblioteca.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "datanascimento")
    private LocalDate birthDate;

    @Column(name = "cpf")
    private String document;

    @Column(name = "funcionario")
    private Boolean employee;

    @Column(name = "gerente")
    private Boolean manager;

}
