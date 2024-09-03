package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.Member;
import com.morinaga.christianportal.dto.MemberDto;

import java.util.List;

public interface MemberService {
    Member saveMember(Member member);
    List<Member> getAllMembers();
    MemberDto getMemberById(Long id);
    Member createMember(Member member);
    Member updateMember(Long id, Member memberDetails);
    void deleteMember(Long id);

    void deleteMemberById(Long memberId);

    List<MemberDto> findAllMembers();
}
