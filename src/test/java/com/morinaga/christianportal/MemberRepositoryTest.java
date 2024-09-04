package com.morinaga.christianportal;


import com.morinaga.christianportal.dto.MemberDto;
import com.morinaga.christianportal.model.Member;
import com.morinaga.christianportal.model.ServiceRole;
import com.morinaga.christianportal.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
//@ExtendWith(SpringExtension.class) // for JUnit 5
//@SpringBootTest
@ActiveProfiles("test")
@Import(TestDataConfig.class)
//@AutoConfigureTestDatabase
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void setUp() {
        // Insert test data into the database
        Member member1 = new Member(1L, "John", "Doe", "johndoe@example.com", "1234567890", ServiceRole.SINGER);
        Member member2 = new Member(2L, "Jane", "Smith", "janesmith@example.com", "0987654321", ServiceRole.PREACHER);

        memberRepository.save(member1);
        memberRepository.save(member2);
    }

    @Test
    public void testFindAllMembers() {
        List<MemberDto> members = memberRepository.findAllMembers();

        // Assert that the correct number of members are returned
        assertEquals(2, members.size());

        // Assert that the first member is as expected
        MemberDto member1 = members.get(0);
        assertEquals(1L, member1.getMemberId());
        assertEquals("John", member1.getFirstName());
        assertEquals("Doe", member1.getLastName());
        assertEquals("johndoe@example.com", member1.getEmail());
        assertEquals("1234567890", member1.getPhoneNumber());
        assertEquals(ServiceRole.SINGER, member1.getServiceRole());

        // Assert that the second member is as expected
        MemberDto member2 = members.get(1);
        assertEquals(2L, member2.getMemberId());
        assertEquals("Jane", member2.getFirstName());
        assertEquals("Smith", member2.getLastName());
        assertEquals("janesmith@example.com", member2.getEmail());
        assertEquals("0987654321", member2.getPhoneNumber());
        assertEquals(ServiceRole.PREACHER, member2.getServiceRole());
    }

    @Test
    public void testFindMemberDtoById() {
        Optional<MemberDto> memberDto = memberRepository.findMemberDtoById(1L);
        assertTrue(memberDto.isPresent());

        // Assert that the member data is as expected
        MemberDto member = memberDto.get();
        assertEquals(1L, member.getMemberId());
        assertEquals("John", member.getFirstName());
        assertEquals("Doe", member.getLastName());
        assertEquals("johndoe@example.com", member.getEmail());
        assertEquals("1234567890", member.getPhoneNumber());
        assertEquals(ServiceRole.SINGER, member.getServiceRole());
    }
}


//@DataJpaTest
//public class MemberRepositoryTest {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @BeforeEach
//    public void setUp() {
//        // Insert test data into the database
//        Member member1 = new Member(1L, "John", "Doe", "johndoe@example.com", "1234567890", ServiceRole.SINGER);
//        Member member2 = new Member(2L, "Jane", "Smith", "janesmith@example.com", "0987654321", ServiceRole.PREACHER);
//
//        memberRepository.save(member1);
//        memberRepository.save(member2);
//    }
//
//    @Test
//    public void testFindAllMembers() {
//        List<MemberDto> members = memberRepository.findAllMembers();
//
//        // Assert that the correct number of members are returned
//        assertEquals(2, members.size());
//
//        // Assert that the first member is as expected
//        MemberDto member1 = members.get(0);
//        assertEquals(1L, member1.getMemberId());
//        assertEquals("John", member1.getFirstName());
//        assertEquals("Doe", member1.getLastName());
//        assertEquals("johndoe@example.com", member1.getEmail());
//        assertEquals("1234567890", member1.getPhoneNumber());
//        assertEquals(ServiceRole.SINGER, member1.getServiceRole());
//
//        // Assert that the second member is as expected
//        MemberDto member2 = members.get(1);
//        assertEquals(2L, member2.getMemberId());
//        assertEquals("Jane", member2.getFirstName());
//        assertEquals("Smith", member2.getLastName());
//        assertEquals("janesmith@example.com", member2.getEmail());
//        assertEquals("0987654321", member2.getPhoneNumber());
//        assertEquals(ServiceRole.PREACHER, member2.getServiceRole());
//    }
//
//    @Test
//    public void testFindMemberDtoById() {
//        Optional<MemberDto> memberDto = memberRepository.findMemberDtoById(1L);
//        assertTrue(memberDto.isPresent());
//
//        // Assert that the member data is as expected
//        MemberDto member = memberDto.get();
//        assertEquals(1L, member.getMemberId());
//        assertEquals("John", member.getFirstName());
//        assertEquals("Doe", member.getLastName());
//        assertEquals("johndoe@example.com", member.getEmail());
//        assertEquals("1234567890", member.getPhoneNumber());
//        assertEquals(ServiceRole.SINGER, member.getServiceRole());
//    }
//}

