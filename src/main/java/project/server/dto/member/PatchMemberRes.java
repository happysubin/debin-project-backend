package project.server.dto.member;

import lombok.Getter;
import lombok.Setter;
import project.server.domain.Member;

@Getter
@Setter
public class PatchMemberRes {

    public PatchMemberRes(Member member){
        this.email = member.getEmail();
        this.loginId = member.getLoginId();
        this.userName = member.getUserName();
        this.name = member.getName();
        this.password = member.getPassword();
        this.status = member.getStatus();
    }

    private String email;

    private String loginId;

    private String userName;

    private String name;

    private String password;

    private String status;
}
