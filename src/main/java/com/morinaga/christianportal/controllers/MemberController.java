package com.morinaga.christianportal.controllers;

import com.morinaga.christianportal.config.ResourceNotFoundException;
import com.morinaga.christianportal.model.Member;
import com.morinaga.christianportal.dto.MemberDto;
import com.morinaga.christianportal.repositories.MemberRepository;
import com.morinaga.christianportal.repositories.UserRegistrationDto;
import com.morinaga.christianportal.services.MemberService;
import com.morinaga.christianportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//Ensure that your backend psrovides an endpoint to fetch members

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final UserService userService;

    @Autowired
    public MemberController(MemberService memberService, UserService userService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.userService = userService;
        this.memberRepository = memberRepository;
    }

//    @GetMapping
//    public List<Member> getAllMembers() {
//        return memberService.getAllMembers();
//    }


    @GetMapping
    public List<MemberDto> getAllMembers() {
        return memberService.findAllMembers();
    }
//    @GetMapping
//    public List<UserRegistrationDto> getAllMembers() {
//        List<UserRegistrationDto> collect = memberService.getAllMembers().stream().map(this::convertToDto).collect(Collectors.toList());
//        return collect;
//    }
//
//    private UserRegistrationDto convertToDto(Member member) {
//        UserRegistrationDto dto = new UserRegistrationDto();
//        dto.setUsername(member.getUser().getUsername());
//        dto.setEmail(member.getUser().getEmail());
//        dto.setFirstName(member.getFirstName());
//        dto.setLastName(member.getLastName());
//        dto.setPhoneNumber(member.getPhoneNumber());
//        dto.setServiceRole(member.getServiceRole());
//        return dto;
//    }


    //    @GetMapping("/{id}")
//    public Member getMemberById(@PathVariable Long id) {
//        return memberService.getMemberById(id);
//    }
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable Long memberId) {
        try {
            MemberDto memberDto = memberService.getMemberById(memberId);
            return ResponseEntity.ok(memberDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
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

    @PutMapping("/{memberId}")
    public Member updateMember(@PathVariable Long memberId, @RequestBody Member memberDetails) {
        return memberService.updateMember(memberId, memberDetails);
    }

//    @DeleteMapping("/{id}")
//    public void deleteMember(@PathVariable Long id) {
//        memberService.deleteMember(id);
//
//    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();

    }
}
//    @DeleteMapping("/users/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
//        userService.deleteUserById(userId);
//        return ResponseEntity.noContent().build();
//    }
//}

