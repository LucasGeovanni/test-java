package br.com.biblioteca.mapper;

import br.com.biblioteca.model.Person;
import br.com.biblioteca.model.dto.PersonRequest;
import br.com.biblioteca.model.dto.PersonResponse;

public class PersonMapper {

    public static PersonResponse mountPersonResponse(Person person) {
        return PersonResponse.builder()
                .id(person.getId())
                .name(person.getName())
                .document(person.getDocument())
                .employee(person.getEmployee())
                .manager(person.getManager())
                .birthDate(Utils.toDate(person.getBirthDate()))
                .build();
    }

    public static Person mountPersonRequest(PersonRequest request) {
        return Person.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .document(request.getDocument())
                .employee(request.getEmployee())
                .manager(request.getManager())
                .build();
    }
}
