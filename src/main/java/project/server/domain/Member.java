package project.server.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Table(name="MEMBER")
public class Member {

    public Member(){

    }


    public Member(String email, String loginId, String userName, String name, String password,String status){
        this.email = email;
        this.loginId = loginId;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public void updateMemberInfo(String email, String loginId, String userName, String name, String password){
        this.email = email;
        this.loginId = loginId;
        this.userName = userName;
        this.name = name;
        this.password = password;
    }

    public void changeStatusToInActive(){
        this.status = "INACTIVE";
    }

    public void changeStatusToActive(){
        this.status = "ACTIVE";
    }

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String loginId;

    private String userName;

    private String name;

    private String password;

    private String status;


}
