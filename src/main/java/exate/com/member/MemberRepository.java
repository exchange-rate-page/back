package exate.com.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        if(member.getId() == null) {
            em.persist(member);
            return;
        }
        em.merge(member);
    }
}
