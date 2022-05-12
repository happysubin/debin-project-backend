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
public class PutMemberReq {

    public PutMemberReq(String email, String nickName, String name, String password){
        this.email = email;
        this.nickName = nickName;
        this.name = name;
        this.password = password;
    }


    @Email
    @NotBlank
    private String email;

    @Size(min=6)
    @NotBlank
    private String nickName;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min=10)
    private String password;
}
