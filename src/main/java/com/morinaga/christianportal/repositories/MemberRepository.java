package com.morinaga.christianportal.repositories;

import com.morinaga.christianportal.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{


}
