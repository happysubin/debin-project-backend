package project.server.dto.member;

import lombok.Getter;
import lombok.Setter;
import project.server.domain.Member;

@Getter
@Setter
public class GetMemberRes {

    public GetMemberRes(Member member){
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

//@Getter을 사용하지 않아서 406에러가 발생했다. 게터를 꼭 쓰자!
