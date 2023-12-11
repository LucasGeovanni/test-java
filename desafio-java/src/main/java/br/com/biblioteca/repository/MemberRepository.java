package br.com.biblioteca.repository;

import br.com.biblioteca.model.Member;
import br.com.biblioteca.model.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, MemberId> {

    @Query("SELECT u FROM Member u WHERE u.project.id = :projectId")
    List<Member> findByProjectId(Long projectId);
}
