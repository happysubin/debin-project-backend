package project.server.unit.repository.member;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import project.server.domain.Member;
import project.server.exception.member.MemberNotFoundException;
import project.server.factory.MemberFactory;
import project.server.repository.member.MemberRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {



    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach()
    void setMembers(){
        /*
        ArrayList<Member> members = MemberFactory.createTestMembers();
        for (Member member : members) {
            memberRepository.save(member);
        }

        testEntityManager.flush();
        testEntityManager.clear();
        */
        memberRepository.deleteAll();
    }

    @Test
    void createMember(){
        //given
        Member member = MemberFactory.createTestMember();

        //when
        Member findMember = memberRepository.save(member);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        Assertions.assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
    }

    @Test
    void updateMemberInfo(){
        //given
        Member member = MemberFactory.createTestMember();
        memberRepository.save(member);

        //when
        Member findMember = memberRepository.findByNickName("testUserName").orElseThrow(MemberNotFoundException::new);
        MemberFactory.updateTestMember(findMember);

        //then
        Assertions.assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
    }

    @Test
    void changeMemberStatus(){
        //given
        Member member = MemberFactory.createTestMember();
        memberRepository.save(member);

        //when
        Member findMember = memberRepository.findByNickName("testUserName").orElseThrow(MemberNotFoundException::new);
        MemberFactory.changeStatusTestMember(findMember);

        //then
        Assertions.assertThat(member.getStatus()).isEqualTo("INACTIVE");
    }


}

//assertThat(actual).isEqualTo(expected)
//TestEntityManager JPA 테스트에 사용하기 위한 EntityManager의 대안입니다.
// 테스트에 유용한 EntityManager 메서드의 하위 집합과 지속성/플러시/찾기와 같은 일반적인 테스트 작업에 대한 도우미 메서드를 제공합니다.