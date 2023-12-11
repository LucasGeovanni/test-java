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
@Table(name = "Projeto")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_inicio")
    private LocalDate startDate;

    @Column(name = "data_previsao_fim")
    private LocalDate expectedEndDate;

    @Column(name = "data_fim")
    private LocalDate endDate;

    @Column(name = "descricao")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "orcamento")
    private Float budget;

    @Column(name = "risco")
    private String risk;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private Person manager;

}