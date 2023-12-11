package br.com.biblioteca.repository;

import br.com.biblioteca.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
