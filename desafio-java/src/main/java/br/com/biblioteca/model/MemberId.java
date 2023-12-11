package br.com.biblioteca.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MemberId implements Serializable {

    @Column(name = "idprojeto")
    private Long idProject;

    @Column(name = "idpessoa")
    private Long idPerson;

}
