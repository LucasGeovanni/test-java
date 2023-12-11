package br.com.biblioteca.repository;

import br.com.biblioteca.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByManagerIs(Boolean gerente);

}
