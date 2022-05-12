package project.server.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.server.domain.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {


    @Query("select m from Member m where m.nickName = :nickName ")
    public Optional<Member> findByNickName(String nickName);

}
