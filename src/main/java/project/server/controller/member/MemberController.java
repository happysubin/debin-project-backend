package project.server.controller.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.server.dto.member.*;
import project.server.service.member.MemberService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @ResponseBody
    @GetMapping("/{userId}")
    public GetMemberRes getListMembers(@PathVariable Long userId){
        return memberService.getMember(userId);
    }

    @PostMapping
    public PostMemberRes createMember(@Validated @RequestBody PostMemberReq postUserReq){
        return memberService.createMember(postUserReq);
    }

    @PutMapping("/{userId}")
    public PutMemberRes updateMemberInfo(@Validated @RequestBody PutMemberReq putMemberReq, @PathVariable Long userId){
        PutMemberRes putMemberRes = memberService.updateMember(putMemberReq, userId);
        return putMemberRes;
    }


    @PatchMapping("/{userId}")
    public PatchMemberRes changeMemberStatusToInActive(@PathVariable Long userId){
        PatchMemberRes patchMemberRes = memberService.changeMemberStatusToInActive(userId);
        return patchMemberRes;
    }
}
