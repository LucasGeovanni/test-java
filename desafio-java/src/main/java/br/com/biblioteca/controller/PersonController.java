package br.com.biblioteca.controller;

import br.com.biblioteca.model.dto.PersonRequest;
import br.com.biblioteca.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody PersonRequest request) {
        return ResponseEntity.ok(personService.save(request));
    }
}
