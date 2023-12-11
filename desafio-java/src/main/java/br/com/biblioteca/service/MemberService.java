package br.com.biblioteca.service;

import br.com.biblioteca.model.dto.MemberResponse;

public interface MemberService {

    MemberResponse findByProjectId(Long projectId);

    void addMember(Long projectId, Long personId);

    void deleteMember(Long projectId, Long personId);
}
