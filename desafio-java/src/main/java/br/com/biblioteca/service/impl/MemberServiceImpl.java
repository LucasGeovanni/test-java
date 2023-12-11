package br.com.biblioteca.service.impl;

import br.com.biblioteca.mapper.PersonMapper;
import br.com.biblioteca.model.Member;
import br.com.biblioteca.model.MemberId;
import br.com.biblioteca.model.dto.MemberResponse;
import br.com.biblioteca.model.dto.PersonResponse;
import br.com.biblioteca.repository.MemberRepository;
import br.com.biblioteca.repository.PersonRepository;
import br.com.biblioteca.repository.ProjectRepository;
import br.com.biblioteca.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PersonRepository personRepository;

    private final ProjectRepository projectRepository;


    @Override
    public MemberResponse findByProjectId(Long projectId) {
        log.info("Buscando membros do projeto Id: {}", projectId);
        List<Member> members = memberRepository.findByProjectId(projectId);
        MemberResponse response = new MemberResponse();
        response.setProjectId(projectId);
        List<PersonResponse> listPerson = members.stream().map(m -> PersonMapper.mountPersonResponse(m.getPerson())).collect(Collectors.toList());
        response.setListPerson(listPerson);
        return response;
    }

    @Transactional
    @Override
    public void addMember(Long projectId, Long personId) {
        log.info("Adicionando novo membro Id: {} do projeto de Id: {}", personId, projectId);
        memberRepository.save(Member.builder()
                .id(getMemberId(projectId, personId))
                        .person(personRepository.getById(personId))
                        .project(projectRepository.getById(projectId))
                .build());
    }

    private static MemberId getMemberId(Long projectId, Long personId) {
        return MemberId.builder()
                .idProject(projectId)
                .idPerson(personId)
                .build();
    }

    @Override
    public void deleteMember(Long projectId, Long personId) {
        log.info("Deletando membro Id: {} do projeto de Id: {}", personId, projectId);
        MemberId memberId = getMemberId(projectId, personId);
        memberRepository.deleteById(memberId);
    }
}
