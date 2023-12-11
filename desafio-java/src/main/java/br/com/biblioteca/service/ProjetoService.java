package br.com.biblioteca.service;

import br.com.biblioteca.model.dto.ProjectRequest;
import br.com.biblioteca.model.dto.ProjectResponse;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {


    List<ProjectResponse> findAll();
    Optional<ProjectResponse> findById(Long id);

    Long save(ProjectRequest projectRequest);

    void delete(Long id);

    Long update(ProjectRequest projectRequest);

}
