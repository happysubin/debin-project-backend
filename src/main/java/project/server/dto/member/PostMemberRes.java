package project.server.dto.member;


import lombok.Getter;
import lombok.Setter;
import project.server.domain.Member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostMemberRes {

    public PostMemberRes(Member member){
        this.email = member.getEmail();
        this.nickName = member.getNickName();
        this.name = member.getName();
        this.password = member.getPassword();
        this.status = member.getStatus();
    }



    private String email;

    private String nickName;

    private String name;

    private String password;

    private String status;
}
