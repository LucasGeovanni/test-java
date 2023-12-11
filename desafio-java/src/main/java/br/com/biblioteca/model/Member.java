package br.com.biblioteca.model;


import lombok.*;

import javax.persistence.*;


@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Membros")
public class Member {

    @EmbeddedId
    private MemberId id;

    @ManyToOne
    @JoinColumn(name = "idprojeto", referencedColumnName = "id", insertable = false, updatable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "idpessoa", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

}