package project.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.server.domain.Member;
import project.server.repository.MemberRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getListMember(){
        List<Member> all = memberRepository.findAll();
        return all;
    }

    @Transactional(readOnly = false)
    @PostConstruct
    public void setData(){
        memberRepository.save(new Member("ho"));
        memberRepository.save(new Member("ho1"));
    }
}
