package project.server.dto.member;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class PostMemberReq {

    public PostMemberReq(String email, String loginId, String userName, String name, String password){
        this.email = email;
        this.loginId = loginId;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.status = "ACTIVE";
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

    @NotEmpty
    private String status;
}
