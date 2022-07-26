package Spring2.exercise.product;

import Spring2.exercise.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private ProductChange productChange;
    private final EntityManager em;

    public void save(Product product) {
        if(product.getId() == null) {
            em.persist(product);
        }
        else {
            em.merge(product);
        }
    }

    public void Change(Product product) {
        productChange.change(product);
    }

    public List<Product> findAll() {
        return em.createQuery("select p from Product as p", Product.class)
                .getResultList();
    }

    public Product findOne(Long id) {
        return em.find(Product.class, id);
    }
}
