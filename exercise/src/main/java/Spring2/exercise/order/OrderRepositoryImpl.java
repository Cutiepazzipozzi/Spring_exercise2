package Spring2.exercise.order;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepositoryImpl {
    @PersistenceContext
    private EntityManager em;

    public void createOrder(Order order) {
        em.persist(order);
    }

    public List<Order> findAll() {
        return em.createQuery("select c from Order as c", Order.class)
                .getResultList();
    }

    public void deleteOrder(Order order) {
        em.remove(order);
    }


}
