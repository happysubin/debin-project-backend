package project.server.domain;

import lombok.Getter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Table(name="MEMBER",uniqueConstraints = {
        @UniqueConstraint(name="EMAIL_UNIQUE", columnNames =  {"EMAIL"}),
        @UniqueConstraint(name ="nickName_UNIQUE",columnNames = {"nickName"})})
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String nickName;

    private String name;

    private String password;

    private String status;

    public Member(){
    }

    public Member(String email, String nickName, String name, String password,String status){
        this.email = email;
        this.nickName = nickName;
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public void updateMemberInfo(String email, String nickName, String name, String password){
        this.email = email;
        this.nickName = nickName;
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
