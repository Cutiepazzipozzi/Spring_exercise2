package Spring2.exercise.member;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member as m", Member.class)
                .getResultList();
    }


}
