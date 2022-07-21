package Spring2.exercise.product;

import Spring2.exercise.order.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepository {

    private ProductChange productChange;
    @PersistenceContext
    private EntityManager em;

    public void save(Product product) {
        em.persist(product);
    }

    public void Change(Product product) {
        productChange.change(product);
    }

    public List<Product> findAll() {
        return em.createQuery("select p from Product as p", Product.class)
                .getResultList();
    }
}
