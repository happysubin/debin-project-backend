package project.server.unit.service.member;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import project.server.domain.Member;
import project.server.dto.member.*;
import project.server.factory.MemberFactory;
import project.server.repository.member.MemberRepository;
import project.server.service.member.MemberService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  //JUnit5에서는 ExtendWith를 쓰도록 되어있다
class MemberServiceTest {

    @InjectMocks //Mock 객체를 주입 받는다.
    MemberService memberService;

    @Mock //Mock 객체
    MemberRepository memberRepository;

    @Test
    void createMember() {
        //given
        PostMemberReq dto = PostMemberReq.testData;
        Member member = new Member(dto.getEmail(),dto.getNickName(),dto.getName(),dto.getPassword(),dto.getStatus());

        //mocking 내부 동작을 지정
        given(memberRepository.save(Mockito.any())).willReturn(member);

        //when
        PostMemberRes result = memberService.createMember(dto);

        //then
        assertThat(dto.getEmail()).isEqualTo(result.getEmail());

    }

    @Test
    void updateMember() {

        //given
        PutMemberReq dto = PutMemberReq.testData;
        Member member = MemberFactory.createTestMember();

        System.out.println("member.getEmail() = " + member.getEmail());
        System.out.println("dto.getEmail() = " + dto.getEmail());

        //mocking
        given(memberRepository.findById(Mockito.any())).willReturn(Optional.of(member));

        //when
        PutMemberRes putMemberRes = memberService.updateMember(dto,1L);
        
        //then
        System.out.println();
        System.out.println("putMemberRes = " + putMemberRes.getEmail());
        System.out.println("member.getEmail() = " + member.getEmail());
        System.out.println("dto.getEmail() = " + dto.getEmail());
        
        assertThat(member.getEmail()).isEqualTo(putMemberRes.getEmail());
    }

    @Test
    void changeMemberStatusToInActive() {
        //given
        Long tmp = 1L;
        Member member = MemberFactory.createTestMember();

        given(memberRepository.findById(Mockito.any())).willReturn(Optional.of(member));

        //given
        PatchMemberRes patchMemberRes = memberService.changeMemberStatusToInActive(tmp);

        assertThat(patchMemberRes.getStatus()).isEqualTo("INACTIVE");


    }

    @Test
    void getMemberByNickName() {
        //given
        Member testMember = MemberFactory.createTestMember();
        String nickName = testMember.getNickName();

        given(memberRepository.findByNickName(Mockito.any())).willReturn(Optional.of(testMember));

        //when
        GetMemberRes memberByNickName = memberService.getMemberByNickName(nickName);

        assertThat(memberByNickName.getNickName()).isEqualTo(nickName);



    }
}