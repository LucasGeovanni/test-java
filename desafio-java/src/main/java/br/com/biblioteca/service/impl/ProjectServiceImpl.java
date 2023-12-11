package br.com.biblioteca.service.impl;

import br.com.biblioteca.mapper.PersonMapper;
import br.com.biblioteca.model.Person;
import br.com.biblioteca.model.Project;
import br.com.biblioteca.model.dto.BusinessException;
import br.com.biblioteca.model.dto.ProjectRequest;
import br.com.biblioteca.model.dto.ProjectResponse;
import br.com.biblioteca.model.enuns.RiskEnum;
import br.com.biblioteca.model.enuns.StatusProjectEnum;
import br.com.biblioteca.repository.ProjectRepository;
import br.com.biblioteca.service.PersonService;
import br.com.biblioteca.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.biblioteca.model.enuns.StatusProjectEnum.*;


@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjetoService {

    private final ProjectRepository projectRepository;

    private final PersonService personService;

    @Override
    public List<ProjectResponse> findAll() {
        return projectRepository.findAll().stream().map(ProjectServiceImpl::mountProjectResponse).collect(Collectors.toList());
    }



    @Override
    public Optional<ProjectResponse> findById(Long id) {
        return projectRepository.findById(id).map(ProjectServiceImpl::mountProjectResponse);
    }

    @Override
    public Long save(ProjectRequest request) {
        if (Objects.isNull(request)) {
            throw new BusinessException("Requisicao invalida!");
        }
        Project entity = projectRepository.save(Project.builder()
                        .id(request.getId())
                        .name(request.getName())
                        .startDate(request.getStartDate())
                        .endDate(request.getEndDate())
                        .expectedEndDate(request.getExpectedEndDate())
                        .description(request.getDescription())
                        .budget(request.getBudget())
                        .risk(request.getRisk().getDescription())
                        .status(request.getStatus().getDescription())
                        .manager(personService.findById(request.getManager()).orElseThrow(()-> new BusinessException("Pessoa Nao cadastrada no sistema!")))
                .build());
        return entity.getId();
    }

    @Override
    public void delete(Long id) {
        projectRepository.findById(id).ifPresent(project -> {
            if (INICIADO.getDescription().equals(project.getStatus()) || EM_ANDAMENTO.getDescription().equals(project.getStatus()) || ENCERRADO.getDescription().equals(project.getStatus())) {
                throw new BusinessException("Nao e permitido excluir um projeto com o status de " + project.getStatus());
            }
            log.info("Deletando projeto ID: {}", id);
            projectRepository.delete(project);
        });
    }

    @Override
    public Long update(ProjectRequest request) {
        if (Objects.isNull(request) || Objects.isNull(request.getId())) {
            throw new BusinessException("Id Nulo ou Invalid!");
        }
        log.info("Atualizando o request de Id {}", request.getId());
        return save(request);
    }

    private static ProjectResponse mountProjectResponse(Project p) {

        ProjectResponse projectResponse = ProjectResponse.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .startDate(toDate(p.getStartDate()))
                .dateForecastEnd(toDate(p.getExpectedEndDate()))
                .endDate(toDate(p.getEndDate()))
                .status(StatusProjectEnum.toEnum( p.getStatus()))
                .risk(RiskEnum.toEnum(p.getRisk()))
                .budget(p.getBudget())
                .build();

        Person manager = p.getManager();

        if (Objects.nonNull(manager)) {
            projectResponse.setManager(PersonMapper.mountPersonResponse(manager));
        }

        return projectResponse;
    }

    public static Date toDate(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
