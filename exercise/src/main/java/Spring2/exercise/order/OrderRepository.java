package Spring2.exercise.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void join(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        String jpql = "select o From Order o join o.member m";
        boolean first = true;

        //회원이름
        if(StringUtils.hasText(orderSearch.getMemberName())) {
            if(first) {
                jpql += " where";
                first = false;
            }
            else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000);

        if(StringUtils.hasText(orderSearch.getMemberName())) {
            query = query.setParameter("name", orderSearch.getMemberName());
        }

        return query.getResultList();
    }

    public void deleteOrder(Order order) {
        em.remove(order);
    }
}
