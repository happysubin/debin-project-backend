package project.server.dto.member;

import lombok.Getter;
import lombok.Setter;
import project.server.domain.Member;

@Getter
@Setter
public class GetMemberRes {

    public GetMemberRes(Member member){
        this.email = member.getEmail();
        this.nickName= member.getNickName();
        this.name = member.getName();
        this.password = member.getPassword();
    }

    private String email;

    private String nickName;

    private String name;

    private String password;
}

//@Getter을 사용하지 않아서 406에러가 발생했다. 게터를 꼭 쓰자!
