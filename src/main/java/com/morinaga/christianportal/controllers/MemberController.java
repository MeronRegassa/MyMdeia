package com.morinaga.christianportal.controllers;

import com.morinaga.christianportal.model.Member;
import com.morinaga.christianportal.repositories.MemberRepository;
import com.morinaga.christianportal.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Ensure that your backend provides an endpoint to fetch members

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }


    // Adding the `addMember` method as an alias to `createMember`
    @PostMapping("/add")
    public Member addMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        return memberService.updateMember(id, memberDetails);
    }

//    @DeleteMapping("/{id}")
//    public void deleteMember(@PathVariable Long id) {
//        memberService.deleteMember(id);
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}

