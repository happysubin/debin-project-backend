package project.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.server.domain.Member;
import project.server.repository.MemberRepository;
import project.server.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //@ResponseBody
    @RequestMapping
    public List<Member> getListUsers(){
        List<Member> listMember = memberService.getListMember();
        return listMember;

    }
}
