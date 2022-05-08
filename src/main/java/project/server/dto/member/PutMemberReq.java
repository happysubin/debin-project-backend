package project.server.dto.member;

import lombok.Getter;
import lombok.Setter;
import project.server.domain.Member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PutMemberReq {

    public PutMemberReq(String email, String loginId, String userName, String name, String password){
        this.email = email;
        this.loginId = loginId;
        this.userName = userName;
        this.name = name;
        this.password = password;
    }


    @Email
    private String email;

    @NotBlank
    private String loginId;

    @NotBlank
    private String userName;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min=10)
    private String password;
}