package project.server.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.server.domain.Member;
import project.server.dto.member.*;
import project.server.service.member.MemberService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ResponseBody
    @GetMapping("/{userId}")
    public GetMemberRes getListMembers(@PathVariable Long userId){
        return memberService.getMember(userId);
    }

    @PostMapping
    public void createMember(@RequestBody PostMemberReq postUserReq){
        memberService.createMember(postUserReq);
    }

    @PutMapping("/{userId}")
    public PutMemberRes updateMemberInfo(@RequestBody PutMemberReq putMemberReq, @PathVariable Long userId){
        PutMemberRes putMemberRes = memberService.updateMember(putMemberReq, userId);
        return putMemberRes;
    }


    @PatchMapping("/{userId}")
    public PatchMemberRes changeMemberStatusToInActive(@PathVariable Long userId){
        PatchMemberRes patchMemberRes = memberService.changeMemberStatusToInActive(userId);
        return patchMemberRes;
    }
}
