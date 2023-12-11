package br.com.biblioteca.model.dto;


import lombok.*;

import java.util.List;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {

    private List<PersonResponse> listPerson;
    private Long projectId;
}
