package project.server.domain;

import lombok.Getter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Table(name="MEMBER",uniqueConstraints = {
        @UniqueConstraint(name="EMAIL_UNIQUE", columnNames =  {"EMAIL"}),
        @UniqueConstraint(name ="LOGINID_UNIQUE",columnNames = {"LOGINID"})})
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String loginId;

    private String userName;

    private String name;

    private String password;

    private String status;

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


}
