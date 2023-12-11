package br.com.biblioteca.service.impl;

import br.com.biblioteca.mapper.PersonMapper;
import br.com.biblioteca.model.Person;
import br.com.biblioteca.model.dto.MemberResponse;
import br.com.biblioteca.model.dto.PersonRequest;
import br.com.biblioteca.model.dto.PersonResponse;
import br.com.biblioteca.repository.PersonRepository;
import br.com.biblioteca.service.MemberService;
import br.com.biblioteca.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final MemberService memberService;
    @Override
    public Long save(PersonRequest request) {
        Person person = PersonMapper.mountPersonRequest(request);
        return personRepository.save(person).getId();
    }

    @Override
    public void setAllEmployees(Long projectId, ModelMap model) {
        MemberResponse projectMembers = memberService.findByProjectId(projectId);

        List<PersonResponse> allEmployees = personRepository.findAll().stream()
                .filter(p -> Boolean.TRUE.equals(p.getEmployee()))
                .filter(p -> projectMembers.getListPerson().stream().noneMatch(x -> x.getId().equals(p.getId())))
                .map(PersonMapper::mountPersonResponse).collect(Collectors.toList());

        model.put("projectMembers", projectMembers);
        model.put("allEmployees", allEmployees);
    }

    @Override
    public List<PersonResponse> findAllByGerenteIs(Boolean is) {
        return personRepository.findAllByManagerIs(is).stream().map(PersonMapper::mountPersonResponse).collect(Collectors.toList());
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }


}
