package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.Member;

import java.util.List;

public interface MemberService {
    Member saveMember(Member member);
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    Member createMember(Member member);
    Member updateMember(Long id, Member memberDetails);
    void deleteMember(Long id);
}
