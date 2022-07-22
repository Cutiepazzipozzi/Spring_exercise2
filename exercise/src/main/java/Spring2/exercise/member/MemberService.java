package Spring2.exercise.member;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    public void join(Member member) {
        memberRepository.save(member);
    }
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
