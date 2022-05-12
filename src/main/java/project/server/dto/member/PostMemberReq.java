package project.server.dto.member;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class PostMemberReq {

    public static PostMemberReq testData = new PostMemberReq("123@gmail.com", "user12345", "name12345","password12345");

    public PostMemberReq(String email, String nickName, String name, String password){
        this.email = email;
        this.nickName = nickName;
        this.name = name;
        this.password = password;
        this.status = "ACTIVE";
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

    @NotEmpty
    private String status;


}
