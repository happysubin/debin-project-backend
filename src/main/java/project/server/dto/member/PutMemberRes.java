package project.server.dto.member;

import lombok.Getter;
import lombok.Setter;
import project.server.domain.Member;

@Getter
@Setter
public class PutMemberRes {

    public PutMemberRes(Member member){
        this.email = member.getEmail();
        this.loginId = member.getLoginId();
        this.userName = member.getUserName();
        this.name = member.getName();
        this.password = member.getPassword();
    }

    private String email;

    private String loginId;

    private String userName;

    private String name;

    private String password;
}
