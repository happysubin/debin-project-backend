package project.server.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    public Member(){

    }

    public Member(String userName){
        this.userName = userName;
    }


    @Id
    @GeneratedValue
    private Long id;
    private String userName;


}
