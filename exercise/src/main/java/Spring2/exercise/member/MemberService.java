package Spring2.exercise.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
//작업을 처리할 때 오류가 난다면 되돌릴 수 있다는
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public Long join(Member member) {
        validate(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validate(Member member) {
        List<Member> findMembers =
           memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원!");
        }
    }
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }
}
