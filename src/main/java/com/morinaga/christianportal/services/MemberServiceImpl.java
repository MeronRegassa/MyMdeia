package com.morinaga.christianportal.services;


import com.morinaga.christianportal.config.ResourceNotFoundException;
import com.morinaga.christianportal.dto.MemberDto;
import com.morinaga.christianportal.model.Member;
import com.morinaga.christianportal.repositories.MemberRepository;
import com.morinaga.christianportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Autowired
    private UserRepository userRepository;


    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }


    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }





    @Override
    public MemberDto getMemberById(Long id) {
        return memberRepository.findMemberDtoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + id));
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Long id, Member memberDetails) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + id));

        member.setFirstName(memberDetails.getFirstName());
        member.setLastName(memberDetails.getLastName());
        member.setEmail(memberDetails.getEmail());
        member.setPhoneNumber(memberDetails.getPhoneNumber());
        member.setServiceRole(memberDetails.getServiceRole());

        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + id));
        memberRepository.delete(member);
    }

    @Override
    public void deleteMemberById(Long memberId) {
        // First, delete the related user records
        userRepository.deleteByMemberId(memberId);

        // Then, delete the member
        memberRepository.deleteById(memberId);
    }

    @Override
    public List<MemberDto> findAllMembers() {
      return   memberRepository.findAllMembers();
//        return List.of();
    }


}