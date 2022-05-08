package project.server.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.server.domain.Member;
import project.server.dto.member.*;
import project.server.exception.member.MemberNotFoundException;
import project.server.repository.member.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public GetMemberRes getMember(Long memberId){
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(()->new MemberNotFoundException());

        GetMemberRes getMemberRes = new GetMemberRes(findMember);
        return getMemberRes;
    }

    @Transactional(readOnly = false)
    public void createMember(PostMemberReq postUserReq){

        //나중에 빌더 패턴으로 수정하자.
        Member member = new Member(postUserReq.getEmail(),
                postUserReq.getLoginId(),
                postUserReq.getUserName(),
                postUserReq.getName(),
                postUserReq.getPassword(),
                postUserReq.getStatus());

        memberRepository.save(member);
    }

    @Transactional(readOnly = false)
    public PutMemberRes updateMember(PutMemberReq putMemberReq,Long userId){
        Member findMember = memberRepository.findById(userId)
                .orElseThrow(MemberNotFoundException::new);

        findMember.updateMemberInfo(putMemberReq.getEmail(),
                putMemberReq.getLoginId(),
                putMemberReq.getUserName(),
                putMemberReq.getName(),
                putMemberReq.getPassword());

        PutMemberRes putMemberRes = new PutMemberRes(findMember);
        return putMemberRes;
    }

    @Transactional(readOnly = false)
    public PatchMemberRes changeMemberStatusToInActive(Long userId){
        Member findMember = memberRepository.findById(userId)
                .orElseThrow(MemberNotFoundException::new);

        findMember.changeStatusToInActive();
        PatchMemberRes patchMemberRes = new PatchMemberRes(findMember);
        return patchMemberRes;
    }
}
