package project.server.dto.member;

import lombok.Getter;
import lombok.Setter;
import project.server.domain.Member;

@Getter
@Setter
public class PutMemberRes {

    public PutMemberRes(Member member){
        this.email = member.getEmail();
        this.nickName = member.getNickName();
        this.name = member.getName();
        this.password = member.getPassword();
    }

    private String email;

    private String nickName;

    private String name;

    private String password;
}
