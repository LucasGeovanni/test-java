package br.com.biblioteca.service;

import br.com.biblioteca.model.Person;
import br.com.biblioteca.model.dto.PersonRequest;
import br.com.biblioteca.model.dto.PersonResponse;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface PersonService {


    Long save(PersonRequest request);

    void setAllEmployees(Long projectId, ModelMap model);

    List<PersonResponse> findAllByGerenteIs(Boolean is);

    Optional<Person> findById(Long id);
}
