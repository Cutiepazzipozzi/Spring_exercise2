package Spring2.exercise.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Long save(Member member);
    Optional<Member> findById(Long id);
    List<Member> findALl();
}
