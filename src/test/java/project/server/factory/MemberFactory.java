package project.server.factory;

import project.server.domain.Member;


import java.util.ArrayList;

public class MemberFactory {

    static public Member createTestMember(){
        return new Member("test@email.com",
                "testUserName",
                "testName",
                "testPassword",
                "ACTIVe");
    }

    static public void updateTestMember(Member findMember){
         findMember.updateMemberInfo("testUpdate@email.com",
                "testUpdateUserName",
                "testUpdateName",
                "testUpdatePassword");
    }

    static public void changeStatusTestMember(Member findMember){
        findMember.changeStatusToInActive();
    }
}
