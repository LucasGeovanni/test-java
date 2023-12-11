package br.com.biblioteca.service.impl;

import br.com.biblioteca.model.Project;
import br.com.biblioteca.model.dto.BusinessException;
import br.com.biblioteca.model.dto.ProjectRequest;
import br.com.biblioteca.model.enuns.StatusProjectEnum;
import br.com.biblioteca.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class ProjectServiceTest {

    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    ProjectServiceImpl projectService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void deleteSuccess() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(Project.builder()
                        .id(1L)
                        .status(StatusProjectEnum.ANALISE_APROVADA.getDescription())
                .build()));

        Assertions.assertDoesNotThrow(()-> {
            projectService.delete(1L);
        });
    }

    @Test
    public void deleteError() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(Project.builder()
                .id(1L)
                .status(StatusProjectEnum.INICIADO.getDescription())
                .build()));

        Assertions.assertThrows(BusinessException.class, ()-> {
            projectService.delete(1L);
        });
    }

    @Test
    public void saveError() {
        Assertions.assertThrows(BusinessException.class, ()-> {
            projectService.save(null);
        });
    }

    @Test
    public void updateError() {
        Assertions.assertThrows(BusinessException.class, ()-> {
            projectService.update(ProjectRequest.builder().name("project1")
                            .manager(1L)
                    .build());
        });
    }
}
