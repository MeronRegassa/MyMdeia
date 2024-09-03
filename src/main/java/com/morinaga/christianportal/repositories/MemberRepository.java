package com.morinaga.christianportal.repositories;

import com.morinaga.christianportal.dto.MemberDto;
import com.morinaga.christianportal.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    @Query("SELECT new com.morinaga.christianportal.dto.MemberDto(m.memberId, m.firstName, m.lastName, m.email,  m.phoneNumber, m.serviceRole) FROM Member m")
    List<MemberDto> findAllMembers();

    @Query("SELECT new com.morinaga.christianportal.dto.MemberDto(m.memberId, m.firstName, m.lastName, m.email, m.phoneNumber, m.serviceRole) FROM Member m WHERE m.memberId = :id")
    Optional<MemberDto> findMemberDtoById(@Param("id") Long id);

}
